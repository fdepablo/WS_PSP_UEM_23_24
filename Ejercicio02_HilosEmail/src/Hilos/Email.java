package Hilos;

public class Email {

    private int id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpoTxt;

    public Email(int id, String destinatario, String remitente, String asunto, String cuerpoTxt) {
        this.asunto = asunto;
        this.id = id;
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.cuerpoTxt = cuerpoTxt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpoTxt() {
        return cuerpoTxt;
    }

    public void setCuerpoTxt(String cuerpoTxt) {
        this.cuerpoTxt = cuerpoTxt;
    }

	@Override
	public String toString() {
		return "Email [id=" + id + ", destinatario=" + destinatario + ", remitente=" + remitente + ", asunto=" + asunto
				+ ", cuerpoTxt=" + cuerpoTxt + "]";
	}
}
