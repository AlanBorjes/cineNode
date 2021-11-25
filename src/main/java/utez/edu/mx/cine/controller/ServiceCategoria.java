package utez.edu.mx.cine.controller;


import utez.edu.mx.cine.database.ConnectionMySQL;
import utez.edu.mx.cine.model.Categoria.Categoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/Categoria")
public class ServiceCategoria {
    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> findAll() {
        List<Categoria> listCategoria = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            String query = "SELECT categoria.id, categoria.name FROM categoria;";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setName(rs.getString("name"));
                listCategoria.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return listCategoria;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria getCategoria(@PathParam("id") int idBuscar) {
        Categoria categoria = new Categoria();
        try {
            con = ConnectionMySQL.getConnection();
            String query = "SELECT `id`, `name` FROM `categoria` WHERE id = ?;";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, idBuscar);
            rs = pstm.executeQuery();
            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setName(rs.getString("name"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categoria;
    }
    @POST
    @Path("/create/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean getCategoria( @PathParam("name") String name ){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareCall("INSERT INTO categoria (name) VALUES (?);");
            pstm.setString(1, name);;
            flag = pstm.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }finally{
            closeConnection();
        }
        return flag;
    }

    @POST
    @Path("/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateCategoria(@PathParam("id") int id, @PathParam("name") String name) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareCall("UPDATE categoria SET name = ? WHERE id = ?");
            pstm.setString(1, name);
            pstm.setInt(2, id);

            flag = pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            closeConnection();
        }

        return flag;
    }
    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteCategoria(@PathParam("id") int id) {
        boolean flag = false;

        try {
            con = ConnectionMySQL.getConnection();
            pstm = con.prepareCall("DELETE FROM categoria WHERE id = ?");
            pstm.setInt(1, id);

            flag = pstm.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            closeConnection();
        }

        return flag;
    }
    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}