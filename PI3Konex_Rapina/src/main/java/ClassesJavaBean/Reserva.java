package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Reserva {
    //atributos da reserva

    public int num_reserva;
    public int id_cliente;
    public int id_estabelecimento;
    public int qtd_acompanhantes;
    public String nome_reservado;
    public String reserva_status;
    public String data_criada;
    public String data_reservada;
    public String horario_reservado;
    private String hora_valida_reserva;
    private String hora_valida_saida;

    //metodo construtor
    public Reserva() {
    }

    public int getNum_reserva() {
        return num_reserva;
    }

    public void setNum_reserva(int num_reserva) {
        this.num_reserva = num_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public int getQtd_acompanhantes() {
        return qtd_acompanhantes;
    }

    public void setQtd_acompanhantes(int qtd_acompanhantes) {
        this.qtd_acompanhantes = qtd_acompanhantes;
    }

    public String getNome_reservado() {
        return nome_reservado;
    }

    public void setNome_reservado(String nome_reservado) {
        this.nome_reservado = nome_reservado;
    }

    public String getData_criada() {
        return data_criada;
    }

    public void setData_criada(String data_criada) {
        this.data_criada = data_criada;
    }

    public String getData_reservada() {
        return data_reservada;
    }

    public void setData_reservada(String data_reservada) {
        this.data_reservada = data_reservada;
    }

    public String getHorario_reservado() {
        return horario_reservado;
    }

    public void setHorario_reservado(String horario_reservado) {
        this.horario_reservado = horario_reservado;
    }

    public String getHora_valida_reserva() {
        return hora_valida_reserva;
    }

    public void setHora_valida_reserva(String hora_valida_reserva) {
        this.hora_valida_reserva = hora_valida_reserva;
    }

    public String getHora_valida_saida() {
        return hora_valida_saida;
    }

    public void setHora_valida_saida(String hora_valida_saida) {
        this.hora_valida_saida = hora_valida_saida;
    }

    public String getReserva_status() {
        return reserva_status;
    }

    public void setReserva_status(String reserva_status) {
        this.reserva_status = reserva_status;
    }

}
