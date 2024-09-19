package com.evaluacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.evaluacion.model.tarea;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

   @Autowired
	private JavaMailSender javaMailSender;

    //envio del correo al momento de registrarse 
	public String enviarCorreoConfirmacion(tarea tarea) {
		try {
			//String destinatario=usuario.getCorreo();
			String asunto="Asignacion de Tarea Exitoso";
			String cuerpo="<h1>Bienvenido a nuestra plataforma</h1>"
					+ "<p>Tienes una nueva tarea asignada.</p>"
					+ "<p>Saludos.</p>"
					+ "<p>Feliz Dia.</p>";

			var retorno=enviarCorreo(tarea.getCorreo(),asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente el correo de asignacion";
			}else {
				return "No se pudo envíar el correo de asignacion";
			}

		}catch (Exception e) {
			return "Erro al envíar el correo "+e.getMessage();
		}
	}

    public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);

			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);

			javaMailSender.send(message);
			return true;
		}catch (Exception e) {
			return false;
		}

	}
    
}
