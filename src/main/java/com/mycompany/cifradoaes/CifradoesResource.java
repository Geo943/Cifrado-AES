package com.mycompany.cifradoaes;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import servicio.Cifrado;
import servicio.Crypt;
import servicio.NewMain;
import servicio.SalidaCifrado;

/**
 * REST Web Service
 *
 * @author ghernandez
 */
@Path("/Tarea")
public class CifradoesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CifradoesResource
     */
    public CifradoesResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.cifradoaes.CifradoesResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of CifradoResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cifrado")
    public Response validacion(String cifrado) {
        Cifrado data = new Cifrado();
        Gson gs = new Gson();
        Crypt crip = new Crypt();
        SalidaCifrado salida = new SalidaCifrado();
        data = gs.fromJson(cifrado, servicio.Cifrado.class);

        try {
            String salida1 = crip.encrypt(data.getClave(), data.getVector(), data.getTexto());
            System.out.println("salida de Encriptado = " + salida1);
            salida.setIncriptado(salida1);
            String salida2 = crip.decrypt(data.getClave(), data.getVector(), salida1);
            salida.setDesencriptado(salida2);
            System.out.println("salida de deseEncriptado = " + salida2);
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR!!!!!!!");
        }

        return Response.ok(salida, MediaType.APPLICATION_JSON).build();

    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public CifradoResource getCifradoResource(@PathParam("id") String id) {
        return CifradoResource.getInstance(id);
    }
}
