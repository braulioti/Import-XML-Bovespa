public class Evento {
    private String ativo;
    private String data;
    private String volume;
    private String abertura;
    private String fechamento;
    private String minima;
    private String maxima;
    private String media;

    Evento() {
        this.ativo = new String();
        this.volume = new String();
        this.abertura = new String();
        this.fechamento = new String();
        this.minima = new String();
        this.maxima = new String();
        this.media = new String();
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public void setFechamento(String fechamento) {
        this.fechamento = fechamento;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getAtivo() {
        return ativo;
    }

    public String getData() {
        return data;
    }

    public String getVolume() {
        return volume;
    }

    public String getAbertura() {
        return abertura;
    }

    public String getFechamento() {
        return fechamento;
    }

    public String getMinima() {
        return minima;
    }

    public String getMaxima() {
        return maxima;
    }

    public String getMedia() {
        return media;
    }
}
