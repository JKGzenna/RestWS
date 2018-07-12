package com.soprasteria.ws.rest.service;

import com.soprasteria.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientSopra {

	public static void main(String[] args) {
		
		String urlRestService = "http://localhost:8080/RestWS/rest/SopraServices/validaUsuario";  // probar a despues de mandarlo aqui hacer un getproperty y sacarlo fuera
		System.out.println("######## Invocación de Servicio Rest: ["+urlRestService+"]");

		VOUsuario vo = new VOUsuario();
			
		vo.setUsuario("formacion");   //seteamos asi los parametros porque ya estan declarados en el POJO y al hacerles el get se pueden rellenar o modificar desde cualquier
									  //lado llamando a la variable vo y con el punto. ejecutamos el seteo o la creacion de un nuevo usuario u objeto desde el servicio web
		vo.setPassword("Sopra_Academy");
		vo.setUsuarioCorrecto(false); // siempre lo  inicializamos en  false
			
		ClientConfig clientConfig = new DefaultClientConfig(); 
		/*aqui creamos el cliente como un nuevo objeto, lo instanciamos con el operador new, creamos una nueva 
		instancia de un cliente y la llamamos clientConfig como podria ser otra cosa mientras lo cambairamos en 
		todos los lados */
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);  
		/*ahora a ese clientConfig que hemos creado le pedimos que obtenga sus caracteristicas,
		en este momento vacias para agregarle a esas caracteristicas con un put la configuracion JSON para que parsee nuestro POJO MAPPING DE JAVA, el se encarga de 
		hacerlo, y le decimos que true, que se encargue de buscar ese POJO MAPPING, si no al empezar el servicio rest , cuando el quiere castear el objeto VOUsuario 
		para leer su POJO no puede, ese true dirá que el cliente tiene permiso para castear todos los objetos de la clase main publica que haya, como sabemos que 
		siempre va a ir a por esta la vamos ha hacer static para instanciarla desde  el comienzo del programa y cuando llegue al objeto del main gracias al true, 
		tendra permiso para hacer un POJO MAPPing del pojo al que corresponde esa clase, de esa manera siempre conseguira acceder a lo que exista en el POJO aunque 
		sea private (HACER PRUEBA), ya que el pojo mapping fuerza un casteo hacia el POJO  apesar de ser privadas las propiedades de este */
		Client client = Client.create(clientConfig);
		/*entonces una vez creada la configuracion del cliente, creamos un nuevo cliente, con Client y el nombre que queramos para la variable, en este caso client, 
		entonces decimos, Cliente es igual a la variable cliente y esta variable es igual al resultado de crear un cliente a partir del client config que es el que 
		se ha encargado de recoger los datos del pojo */
		WebResource webResource = client    
		/*ahora creamos un objeto de tipo Webresource al cual le llamamos webResource y es el recurso que se va a consumir con lo cual igualamos la variable que 
		acabamos de igualar webresource a client para que client ya sea contenida en el webresource, y client bebe de clientconfig, con lo cual ya nuestro recurso
		web o webresource que es lo que se va a consumir ya esta preparado para lanzarse en el request, ahora prepararemos dicho request */
				/*nuestro webresource que se va a lanzar ya esta preparado y este envoltorio web tendra que ser invocado en un punto, 
				en este caso en el recurso de la url que a continuación se muestra */
				.resource("http://localhost:8080/RestWS/rest/SopraServices/validaUsuario");//enseñar que esto puede ir en linea pero por estetica definimos abajo ".y la ejecucion"
				ClientResponse response = webResource  
				/*entonces nuestro request ya ha sido enviado y en json gracias al parseo del POJO, ahora ya en el server obtiene la respuesta de la validacion del 
				servlet que hemos creado y alli modifica el webresource y su envoltorio y modela la respuesta añadiendo al envoltorio original un ture o false y 
				ocultando la contraseña, pero el servlet al recibir el json lo parseara a java ya que puede, pero no es capaz de devolverlo en json ni de devolvernos 
				la respuesta ya que esta configurado por defecto con get como toda la web con lo que creamos el objeto response a partir de ClientResponse e igualamos 
				el objeto response al webResource, con lo cual nuestro recurso a cambiado su valor y esta preparado para volver, como????, cambiando su tipo a json 
				con un parseo que hara en el servlet antes de volver gracias al .type("application/json")  y volvera a nosotros gracias a que el servlet tendra la 
				orden de .post(ClienteResponse.class, vo); lo cual nos devolvera como un post de alli a nosotros con la clase cliente responmse ya compilada desde el 
				servlet y e objeto vo (los datos del usuario)*/
				/*ESCRIBIR EN LOS 4 vo QUE VIENEN AHORA usuario para engañarles y forzarles a buscar el error, luego pondremos vo */
				.type("application/json")//enseñar que esto puede ir en linea pero por estetica definimos abajo ".y la ejecucion"
				.post(ClientResponse.class, vo);// el vo es el objeto que vamos a mandar y recibir del servicio
		vo = response.getEntity(VOUsuario.class);// ahora el objeto vo que vamos a recibir se ha nutrido de la clase VOUsuario, en la que ha mapeado su POJO
		System.out.println("######## Response: [Usuario: "+vo.getUsuario()+"]");
		System.out.println("######## Response: [Contraseña correcta: "+vo.isUsuarioCorrecto()+"]");
		// colocamos primero la paalabra usuario y luego vo y ya  lo coge
			
		// con este codigo podreis invoccar cualquier servicio rest desde java android etc, desde codigo, solo tendremos que cambiar urls y objetos y clases, pero el patron siempre el mismo		
	}
}


