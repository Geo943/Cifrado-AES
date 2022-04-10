# Cifrado-AES

Geoffrey Hernandez 7690-14-3807

utilidades:
ide:Netbeans jdk 8.2
Servidor:apache Tomee
Tipo: web service
Tipo: post
Data: Json
Test: SoapUI

Cifrado AES en java como servicio web tipo post

se adujunta la url que se utilizo para el servicio web tipo post 

http://localhost:8080/Cifradoaes/webresources/Tarea/cifrado

{
	"clave":"92AE31A79FEEB2A3",
	"vector":"0123456789ABCDEF",
	"texto":"Tarea cifrado AES"
	
	}
  
 obteniendo una json de respuesta con el cifrado y des cifrado del la cadena de caracteres.
 
 {
   "desencriptado": "Tarea cifrado AES",
   "incriptado": "EWoIi/OHni6bTn4MijSaEZWhB87lvKVzbqZXGllguIU="
}
