package com.JAVA.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JAVA.project.model.Product;
import com.JAVA.project.service.ProductService;
import com.JAVA.project.util.ProductConstant;
import com.JAVA.project.util.ServiceConstant;

@WebServlet(name = "ProductServlet", urlPatterns = {
		ServiceConstant.PATH_PRODUCT,
		ServiceConstant.PATH_PRODUCT_ADD,
		ServiceConstant.PATH_PRODUCT_UPDATE,
		ServiceConstant.PATH_PRODUCT_DELETE,
		ServiceConstant.PATH_PRODUCT_TEST})  //SEO
public class ProductServlet extends HttpServlet {
	/*
	 * Hiển thị trang product danh sách sản phẩm đang có
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service;
	private boolean checkId = true;
	private boolean checkUpdate = true;
	private int id = 0;
	@Override
	public void init() throws ServletException { // cần hàm init để khi khởi tạo nó sẽ vô hàm này đầu tiên
		super.init();
		service = new ProductService();
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//servlet path

		switch (req.getServletPath()) { 
		case ServiceConstant.PATH_PRODUCT: //Lấy đường dẫn req gửi về
			req.setAttribute("products", service.getAllProducts());
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_HOMEPAGE).forward(req, resp);
			break;
		
		case ServiceConstant.PATH_PRODUCT_DELETE://sau khi chọn xóa thì nó sẽ lấy id người dùng muốn xóa
												//gọi hàm xóa trong class rồi truyền vào id
												// sau đó setAttribute
												// cuối cùng quay lay trang HOME
			service.delete(Integer.valueOf(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() +  ServiceConstant.PATH_PRODUCT);
			break;
		
		case ServiceConstant.PATH_PRODUCT_ADD:
			
			/*
			 * Hiển thị trang Product_ADD
			 *
			 */
			if (this.checkId == false) {
				req.setAttribute("idERR", "DUPLICATE");
				
			}
			else
				req.setAttribute("idERR", "SUCCESSFUL");
			req.setAttribute("command", "ADD");
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
				break;
		
		case ServiceConstant.PATH_PRODUCT_UPDATE:
			if (this.checkUpdate == true)
				id = Integer.valueOf(req.getParameter("id"));
			req.setAttribute("command", "EDIT");
			req.setAttribute("product", service.getProductById(id));
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
			
			break;
		case ServiceConstant.PATH_PRODUCT_TEST:
			service.testConnection();
			break;
		default:
			break;
		};
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) { 
		case ServiceConstant.PATH_PRODUCT_ADD:
			if( req.getParameter("productId") 			== "" ||
				req.getParameter("productName") 		== "" ||
				req.getParameter("productCode")			== "" ||
				req.getParameter("productDescription") 	== "" ||
				req.getParameter("productPrice")		== "" ||
				Float.parseFloat(req.getParameter("productPrice")) < 0) {
				 this.checkId = true;
				resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_PRODUCT_ADD);
				
			}
			else {
				
				  if(service.add(new Product(Integer.valueOf(req.getParameter("productId")), 
						  req.getParameter("productName"),
						  req.getParameter("productCode"), 
						  req.getParameter("productDescription"), 
						  Float.parseFloat(req.getParameter("productPrice"))))) {
					  resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_PRODUCT);
					  this.checkId = true;
					  }
				  else {
					 this.checkId = false;
				  	 resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_PRODUCT_ADD);
				  }
			}
			break;
		case ServiceConstant.PATH_PRODUCT_UPDATE:
			if( req.getParameter("productId") 			== "" ||
				req.getParameter("productName") 		== "" ||
				req.getParameter("productCode")			== "" ||
				req.getParameter("productDescription") 	== "" ||
				req.getParameter("productPrice")		== "" ||
				Float.parseFloat(req.getParameter("productPrice")) < 0) {
				this.checkUpdate = false;
				resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_PRODUCT_UPDATE);
			}
			else {
				this.checkUpdate = true;
				if(service.update(new Product(Integer.valueOf(req.getParameter("productId")),req.getParameter("productName"), req.getParameter("productCode"), req.getParameter("productDescription"), Float.parseFloat(req.getParameter("productPrice"))))== -1)
					System.out.println("Update that bai");
				else 
					System.out.println("Update thanh cong !");
					
				resp.sendRedirect(req.getContextPath() + ServiceConstant.PATH_PRODUCT);
			}
			break;
		default:
			break;

		}
	}
	
}
