/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author aluno
 */
@Entity
public class Avaliacao implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id; 
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Funcionario funcionario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAvaliacao;
    private double altura;
    private double peso;
    private String etnia;
    private String sexo;
    private String condicionamento;
    private String tipoSanguineo;
    private String rh;
    private String pressaoArterial;
    private boolean aptidao;
    private int fcRepouso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimoCheckUp;
    private boolean testeDeEsforco;
    private String estresse;
    private boolean anemia;
    private int glicose;
    private int colesterol;
    private int hdl;
    private int ldl;
    private int triglicerides;
    private boolean fumante;
    private int numeroDeCigarros;
    private boolean jaFumou;
    private double parouA;
    private boolean alergia;
    private String desencadeante;
    private String doencasAnteriores;
    private String doencasFamiliares;
    private String cirurgiasEInternacoes;
    private String lesoesAnt;
    private String medicacao;
    private String avisarEmergencia;
    private String telEmergencia;
    private String medico;
    private String telMedico;
    private String convenio;
    private String hospitalClinica;
    private String nutricionista;
    private String telNutricionista;
    private int refeicoesDiarias;
    private String bebidasAlcoolicas;
    private int ingestaoCaloriaDia;
    private int gastoCaloricoDia;
    private String ingestaoLiquido;
    private String suplementoAlimentar;
    private boolean praticaAtividade;
    private String atividadesFisicas;
    private int frequenciaAtividadeSemanal;
    private int duracaoAtividade;
    private String frequenciaAtividade;
    private boolean praticouAntes;
    private double haQuantoTempo;
    private double porQuantoTempo;
    private String frequenciaAtividadeAnteriorSemanal;
    private int duracaoMinAntes;
    private String intensidadeAntes;
    private String objetivos;
    private String outros;
    private String horarioPerfeito;
    private String atividadeFavorita;
    private int vezesSemanais;
    @Column(columnDefinition="TEXT")
    private String observacoes;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
    
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCondicionamento() {
        return condicionamento;
    }

    public void setCondicionamento(String condicionamento) {
        this.condicionamento = condicionamento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public boolean isAptidao() {
        return aptidao;
    }

    public void setAptidao(boolean aptidao) {
        this.aptidao = aptidao;
    }

    public int getFcRepouso() {
        return fcRepouso;
    }

    public void setFcRepouso(int fcRepouso) {
        this.fcRepouso = fcRepouso;
    }

    public Date getUltimoCheckUp() {
        return ultimoCheckUp;
    }

    public void setUltimoCheckUp(Date ultimoCheckUp) {
        this.ultimoCheckUp = ultimoCheckUp;
    }

    public boolean isTesteDeEsforco() {
        return testeDeEsforco;
    }

    public void setTesteDeEsforco(boolean testeDeEsforco) {
        this.testeDeEsforco = testeDeEsforco;
    }

    public String getEstresse() {
        return estresse;
    }

    public void setEstresse(String estresse) {
        this.estresse = estresse;
    }

    public boolean isAnemia() {
        return anemia;
    }

    public void setAnemia(boolean anemia) {
        this.anemia = anemia;
    }

    public int getGlicose() {
        return glicose;
    }

    public void setGlicose(int glicose) {
        this.glicose = glicose;
    }

    public int getColesterol() {
        return colesterol;
    }

    public void setColesterol(int colesterol) {
        this.colesterol = colesterol;
    }

    public int getHdl() {
        return hdl;
    }

    public void setHdl(int hdl) {
        this.hdl = hdl;
    }

    public int getLdl() {
        return ldl;
    }

    public void setLdl(int ldl) {
        this.ldl = ldl;
    }

    public int getTriglicerides() {
        return triglicerides;
    }

    public void setTriglicerides(int triglicerides) {
        this.triglicerides = triglicerides;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public int getNumeroDeCigarros() {
        return numeroDeCigarros;
    }

    public void setNumeroDeCigarros(int numeroDeCigarros) {
        this.numeroDeCigarros = numeroDeCigarros;
    }

    public boolean isJaFumou() {
        return jaFumou;
    }

    public void setJaFumou(boolean jaFumou) {
        this.jaFumou = jaFumou;
    }

    public double getParouA() {
        return parouA;
    }

    public void setParouA(double parouA) {
        this.parouA = parouA;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public String getDesencadeante() {
        return desencadeante;
    }

    public void setDesencadeante(String desencadeante) {
        this.desencadeante = desencadeante;
    }

    public String getDoencasAnteriores() {
        return doencasAnteriores;
    }

    public void setDoencasAnteriores(String doencasAnteriores) {
        this.doencasAnteriores = doencasAnteriores;
    }

    public String getDoencasFamiliares() {
        return doencasFamiliares;
    }

    public void setDoencasFamiliares(String doencasFamiliares) {
        this.doencasFamiliares = doencasFamiliares;
    }

    public String getCirurgiasEInternacoes() {
        return cirurgiasEInternacoes;
    }

    public void setCirurgiasEInternacoes(String cirurgiasEInternacoes) {
        this.cirurgiasEInternacoes = cirurgiasEInternacoes;
    }

    public String getLesoesAnt() {
        return lesoesAnt;
    }

    public void setLesoesAnt(String lesoesAnt) {
        this.lesoesAnt = lesoesAnt;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getAvisarEmergencia() {
        return avisarEmergencia;
    }

    public void setAvisarEmergencia(String avisarEmergencia) {
        this.avisarEmergencia = avisarEmergencia;
    }

    public String getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(String telEmergencia) {
        this.telEmergencia = telEmergencia;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getTelMedico() {
        return telMedico;
    }

    public void setTelMedico(String telMedico) {
        this.telMedico = telMedico;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getHospitalClinica() {
        return hospitalClinica;
    }

    public void setHospitalClinica(String hospitalClinica) {
        this.hospitalClinica = hospitalClinica;
    }

    public String getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(String nutricionista) {
        this.nutricionista = nutricionista;
    }

    public String getTelNutricionista() {
        return telNutricionista;
    }

    public void setTelNutricionista(String telNutricionista) {
        this.telNutricionista = telNutricionista;
    }

    public int getRefeicoesDiarias() {
        return refeicoesDiarias;
    }

    public void setRefeicoesDiarias(int refeicoesDiarias) {
        this.refeicoesDiarias = refeicoesDiarias;
    }

    public String getBebidasAlcoolicas() {
        return bebidasAlcoolicas;
    }

    public void setBebidasAlcoolicas(String bebidasAlcoolicas) {
        this.bebidasAlcoolicas = bebidasAlcoolicas;
    }
    public int getIngestaoCaloriaDia() {
        return ingestaoCaloriaDia;
    }

    public void setIngestaoCaloriaDia(int ingestaoCaloriaDia) {
        this.ingestaoCaloriaDia = ingestaoCaloriaDia;
    }

    public int getGastoCaloricoDia() {
        return gastoCaloricoDia;
    }

    public void setGastoCaloricoDia(int gastoCaloricoDia) {
        this.gastoCaloricoDia = gastoCaloricoDia;
    }

    public String getIngestaoLiquido() {
        return ingestaoLiquido;
    }

    public void setIngestaoLiquido(String ingestaoLiquido) {
        this.ingestaoLiquido = ingestaoLiquido;
    }

    public String getSuplementoAlimentar() {
        return suplementoAlimentar;
    }

    public void setSuplementoAlimentar(String suplementoAlimentar) {
        this.suplementoAlimentar = suplementoAlimentar;
    }

    public boolean isPraticaAtividade() {
        return praticaAtividade;
    }

    public void setPraticaAtividade(boolean praticaAtividade) {
        this.praticaAtividade = praticaAtividade;
    }

    public String getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setAtividadesFisicas(String atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }

    public int getFrequenciaAtividadeSemanal() {
        return frequenciaAtividadeSemanal;
    }

    public void setFrequenciaAtividadeSemanal(int frequenciaAtividadeSemanal) {
        this.frequenciaAtividadeSemanal = frequenciaAtividadeSemanal;
    }

    public int getDuracaoAtividade() {
        return duracaoAtividade;
    }

    public void setDuracaoAtividade(int duracaoAtividade) {
        this.duracaoAtividade = duracaoAtividade;
    }

    public double getHaQuantoTempo() {
        return haQuantoTempo;
    }

    public void setHaQuantoTempo(double haQuantoTempo) {
        this.haQuantoTempo = haQuantoTempo;
    }

    public double getPorQuantoTempo() {
        return porQuantoTempo;
    }

    public void setPorQuantoTempo(double porQuantoTempo) {
        this.porQuantoTempo = porQuantoTempo;
    }
    public String getFrequenciaAtividadeAnteriorSemanal() {
        return frequenciaAtividadeAnteriorSemanal;
    }

    public void setFrequenciaAtividadeAnteriorSemanal(String frequenciaAtividadeAnteriorSemanal) {
        this.frequenciaAtividadeAnteriorSemanal = frequenciaAtividadeAnteriorSemanal;
    }
    public int getDuracaoMinAntes() {
        return duracaoMinAntes;
    }

    public void setDuracaoMinAntes(int duracaoMinAntes) {
        this.duracaoMinAntes = duracaoMinAntes;
    }

    public String getIntensidadeAntes() {
        return intensidadeAntes;
    }

    public void setIntensidadeAntes(String intensidadeAntes) {
        this.intensidadeAntes = intensidadeAntes;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getHorarioPerfeito() {
        return horarioPerfeito;
    }

    public void setHorarioPerfeito(String horarioPerfeito) {
        this.horarioPerfeito = horarioPerfeito;
    }

    public String getAtividadeFavorita() {
        return atividadeFavorita;
    }

    public void setAtividadeFavorita(String atividadeFavorita) {
        this.atividadeFavorita = atividadeFavorita;
    }

    public int getVezesSemanais() {
        return vezesSemanais;
    }

    public void setVezesSemanais(int vezesSemanais) {
        this.vezesSemanais = vezesSemanais;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getFrequenciaAtividade() {
        return frequenciaAtividade;
    }

    public void setFrequenciaAtividade(String frequenciaAtividade) {
        this.frequenciaAtividade = frequenciaAtividade;
    }

    public boolean isPraticouAntes() {
        return praticouAntes;
    }

    public void setPraticouAntes(boolean praticouAntes) {
        this.praticouAntes = praticouAntes;
    }
    
}
