package com.soprasteria.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;  //IMPORTANTE PARA QUE  NOS COJA EL APPLICATION_JSON EN  EL CONSUMES Y PRODUCES

import com.soprasteria.ws.rest.vo.VOUsuario;
import com.soprasteria.ws.rest.vo.VOUsuarioDNI;

@Path("/SopraServices")
public class ServiceLoginSS {

	@POST   // ctrl+space detras de una anotacion para poder realizar su importacion
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuario validaUsuario(VOUsuario vo){
		vo.setUsuarioCorrecto(false);
		if(vo.getUsuario().equals("formacion") &&vo.getPassword().equals("SopraAcademy")){
        	vo.setUsuarioCorrecto(true);
		}
		vo.setPassword("############");
		return vo;
	}
	
//  Si anidamos los if así nos validará todo junto dandonos false por el dni, por eso hacemoos 2 if	
//	@POST   // ctrl+space detras de una anotacion para poder realizar su importacion
//	@Path("/validaDNI")
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
//	public VOUsuarioDNI validaUsuario(VOUsuarioDNI vo){
//		vo.setUsuarioCorrecto(false);
//		if(vo.getUsuario().equals(".\formacion") &&vo.getPassword().equals("Sopra_Academy")){
//        	vo.setUsuarioCorrecto(true);
//    		vo.setDniCorrecto(false);
//    		if(vo.getUsuario().equals(".\formacion") &&vo.getDni().equals("78915016S")){
//            	vo.setDniCorrecto(true);
//    		}
//		}
//		
//		vo.setPassword("############");
//		return vo;
//	}
	@POST   // ctrl+space detras de una anotacion para poder realizar su importacion
	@Path("/validaDNI")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuarioDNI validaUsuario(VOUsuarioDNI vo){
		vo.setUsuarioCorrecto(false);
		if(vo.getUsuario().equals(".\formacion") &&vo.getPassword().equals("Sopra_Academy")){
        	vo.setUsuarioCorrecto(true);
    		}
		vo.setDniCorrecto(false);
		if(vo.getUsuario().equals(".\formacion") &&vo.getDni().equals("78915016S")){
        	vo.setDniCorrecto(true);
		}
		
		vo.setPassword("############");
		return vo;
	}
}