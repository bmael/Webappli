class PMVServlet
!!!145922.java!!!	processRequest(inout request : HttpServletRequest, inout response : HttpServletResponse) : void
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                    
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PMVServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PMVServlet at " + request.getContextPath() + "</h1>");
            
            try {
                List<PMV> pmvs = pmvContr.getAll();
                String codeJs = new String();
                
                List<ItineraryStats> datas = statsPmvContr.getAll();
                
                int i = 0;
                for (PMV pmv:pmvs) {
                    if ( pmv.isIndic_temps() && datas.size()!=0 ) {
                        codeJs += "my_marker = new mxn.Marker(new mxn.LatLonPoint(" + pmv.getLatitude() + "," + pmv.getLongitude() + "));";
                        codeJs += "my_marker.setIcon('images/marker.png');";
                        codeJs += "my_marker.setInfoDiv('" +datas.get(i).getTime() + " minutes</p>','info');";
                        codeJs += "mapstraction.addMarker(my_marker);";
                        
                        i++;
                    }
                }
                request.setAttribute("codeJs", codeJs);
                request.getServletContext().getRequestDispatcher("/map.jsp").forward(request, response);
            }       catch (FileNotFoundException ex) {
                        Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
!!!146050.java!!!	doGet(inout request : HttpServletRequest, inout response : HttpServletResponse) : void
        processRequest(request, response);
!!!146178.java!!!	doPost(inout request : HttpServletRequest, inout response : HttpServletResponse) : void
        processRequest(request, response);
!!!146306.java!!!	getServletInfo() : String
        return "Short description";
