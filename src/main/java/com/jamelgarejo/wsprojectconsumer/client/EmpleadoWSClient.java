/**
 * 
 */
package com.jamelgarejo.wsprojectconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jamelgarejo.wsprojectconsumer.dto.EmpleadoDTO;

/**
 * @author jamel
 *
 * Clase cliente para consumir WS de empleados
 */
public class EmpleadoWSClient {

	public static void main(String[] args) {
//		peticion GET
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080/ws-project/jamelgarejows/empleadosWS").path("consultarEmpleadoPorId").path("5");
//		
//		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		
//		if(response.getStatus() == 204) {
//			System.out.println("Empleado no encontrado....");
//			return;
//		}
//		
//		EmpleadoDTO empleadoDTO = response.readEntity(EmpleadoDTO.class);
//		System.out.println("Nombre: " + empleadoDTO.getNombre() + " - Apellido: " + empleadoDTO.getApellido());
//		System.out.println("Fecha Creación: " + empleadoDTO.getFechaCreacion());
		
//		peticion POST
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/ws-project/jamelgarejows/empleadosWS").path("guardarEmpleado");
		
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setNumero(5);
		empleadoDTO.setNombre("HUGO BENJAMIN");
		empleadoDTO.setApellido("GALEANO MEDINA");
		empleadoDTO.setEdad(14);
		empleadoDTO.setFechaCreacion(LocalDateTime.now());
		
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(empleadoDTO, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			System.out.println("Empleado almacenado correctamente");
			System.out.println(response.readEntity(EmpleadoDTO.class));
		} else
			System.out.println("ERROR!!");		
	}
}
