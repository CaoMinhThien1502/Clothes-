/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thien
 */
public class mainController extends HttpServlet {

    private String url = "errorpage.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String token = "";
            Cookie[] c = request.getCookies();
            HttpSession session = request.getSession();
            String a = (String) session.getAttribute("name");
            if (a == null || a.equals("")) {
                if (c != null) {
                    for (Cookie aCookie : c) {
                        if (aCookie.getName().equals("selector")) {
                            token = aCookie.getValue();
                            Account acc = AccountDAO.getAccount(token);
                            session.setAttribute("name", acc.getFullname());
                            session.setAttribute("email", acc.getEmail());
                            session.setAttribute("role", acc.getRole());
                        }
                    }
                }
            }
                if (action == null || action.equals("") || action.equals("search")) {
                    url = "index.jsp";
                } else if (action.equals("login")) {
                    url = "loginServlet";
                } else if (action.equals("logout")) {
                    url = "logoutServlet";
                } else if (action.equals("register")) {
                    url = "registerServlet";
                } else if (action.equals("addtocart")) {
                    url = "addToCartServlet";
                } else if (action.equals("viewcart")) {
                    url = "viewcart.jsp";
                }else if (action.equals("clothesdetail")) {
                    url = "getClothesServlet";
                }else if (action.equals("update")) {
                    url = "updateCartServlet";
                } else if (action.equals("delete")) {
                    url = "deleteCartServlet";
                } else if (action.equals("saveOrder")) {
                    url = "saveOrderServlet";
                } else if (action.equals("updateProfile")) {
                    url = "updateProfileServlet";
                }else if (action.equals("cancelOrder")) {
                    url = "cancelOrderServlet";
                }else if (action.equals("received")) {
                    url = "receivedOrderServlet";
                }else if (action.equals("manageAccount")) {
                    url = "listAccount.jsp";
                }else if (action.equals("changeStatusAccount")) {
                    url = "changeStatusServlet";
                }else if (action.equals("blocked")) {
                    url = "changeStatusClothes";
                }else if (action.equals("searchAccount")) {
                    url = "listAccount.jsp";
                }else if (action.equals("manageOrder")) {
                    url = "listOrder.jsp";
                }else if (action.equals("manageClothes")) {
                    url = "listClothes.jsp";
                }else if (action.equals("updateClothes")) {
                    url = "updateClothesServlet";
                }else if (action.equals("addClothes")) {
                    url = "addClothesServlet";
                }
                
                
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
