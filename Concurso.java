package parcial;

import java.util.ArrayList;


public class Concurso {
	
	private String nombre;	
	private ArrayList<Participante> participantes;	
	
	public Concurso(String nombre) {
		
		participantes = new ArrayList<>();
		setNombre(nombre);
		
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	
	public Participante buscar(String dni) { // BUSCAR PARTICIPANTE POR DNI
		Participante ParticipanteEncontrado=null;
		int i=0;
		Participante partlista;
		while(i<participantes.size()&&ParticipanteEncontrado==null) {
			partlista=participantes.get(i);
			if(partlista.getDni().equals(dni)) {
				ParticipanteEncontrado=partlista;
			}else
			{
				i++;
			}
			
		}
		
		return ParticipanteEncontrado;
	}
	
	public boolean agregarParticipante(String dni, String nombre, String apellido) { // AGREGAR PARTICIPANTE
		boolean pude= false;
		Participante nuevoParticipante;
		if(buscar(dni) == null) {
					nuevoParticipante=new Participante(dni,nombre, apellido);
					participantes.add(nuevoParticipante);
					pude=true;				
		}
		
		return pude;
	}
	
	public boolean eliminarParticipante(String dni) { // ELIMIAR PARTICIPANTE
		boolean pude= false;
		Participante deleteParticipante;
		deleteParticipante=buscar(dni);
		if(deleteParticipante!=null) {
			participantes.remove(deleteParticipante);
					pude=true;					
		}
		return pude;
	}
	
	
public void agregar(String dni, String nombre, String apellido) { // AGREGAR CON SYSOS; CAPTURA BOOLEANO
		
		if(agregarParticipante(dni,nombre,apellido)) {
			
			System.out.println("Agregado con exito " + dni + " " + " " + nombre + " " +apellido);
			
		} else {
			
			System.out.println("No se puedo agregar " + dni + " " + " " + nombre + " " +apellido);
		}

		
	}
	
	
	public void elimiar(String dni) { // CAPTURA BOOLEANO DE ELIMAR PARTICIPANTE, MUESTRA MENSAJES.
		
		if(eliminarParticipante(dni)) {
			
			System.out.println("Eliminado con exito" + dni);
			
		} else {
			
			System.out.println("No se pudo eliminar" + dni);
		}

		
	}
	
	
	
	
	public int cantParticipantes() { // CANTIDAD DE PARTICIPANTES
		
		return participantes.size();
		 
	}
	
	
	public void mostrarCantParcitipantes() {
		
		
		System.out.println("La cantidad de participantes es " + cantParticipantes());
		
	}
	
	
	
	public void votarParticipante(String dni) { //VOTAR A PARTICIPANTE
		Participante participante;			
		 participante = buscar(dni);		 
		 if(participante != null) {	
			 	participante.votarParticipante();
				System.out.println("Voto para " + dni); 
			 } else {
				System.out.println("Voto inválido: Dni inexistente"); 
			 }
		 }
		 		
	public void mostrarParcipanteConMasVotos() { // MOSTRAR PARTICIPANTE CON MAS VOTOS
 		Participante ParticipanteMasVotado = null;
 		int max = 0;
 		if (participantes.size() > 0) {
 			for (Participante participante : participantes) {
				if (participante.getVotos() > max) {
					ParticipanteMasVotado = participante;
				}		
 			}
 			
 			System.out.println("Participante mas votado: ");
 			ParticipanteMasVotado.mostarNombreConDni();
 			
 				} else {
			System.out.println("No hay participantes inscriptos ");	 
 				}
	}

	
	 	public void listarPorPuntaje(int puntaje) { // LISTAR PARTICIPANTES A PARTIR DE UN PUNTANJE
	 		int votos;
	 		int sumador=0;
	 		for (Participante participante : participantes) {
	 			votos = participante.getVotos();
	 			if(votos >= puntaje) {
	 				System.out.println(participante);
	 				sumador ++;
	 			}
	 		}
	 			  if(sumador == 0) {
	 	 			System.out.println("No hay participantes para mostrar a partir del puntaje " + puntaje);
	 			}
	 		}
			
		 	public void listarTodosLosParticipantes() { // LISTAR TODOS LOS PARTICIPANTES
		 		System.out.println("Lista de todos los participantes: ");
		 		if(participantes.size() > 0) {
		 		 for (Participante participante : participantes) {	 		 
		 		 System.out.println(participante);	
		 		 }
		 	} else {
		 		System.out.println(" No hay participantes para mostar");
		 	}
		}
	}
