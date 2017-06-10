package com.phonesaragao.modelo;

public class Celular {
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(double memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public double getVelocidadeProcessador() {
		return velocidadeProcessador;
	}
	public void setVelocidadeProcessador(double velocidadeProcessador) {
		this.velocidadeProcessador = velocidadeProcessador;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getTamanhoTela() {
		return tamanhoTela;
	}
	public void setTamanhoTela(double tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}
	public int getMemoriaArmazenamento() {
		return memoriaArmazenamento;
	}
	public void setMemoriaArmazenamento(int memoriaArmazenamento) {
		this.memoriaArmazenamento = memoriaArmazenamento;
	}
	public double getResolucaoCameraFrontal() {
		return resolucaoCameraFrontal;
	}
	public void setResolucaoCameraFrontal(double resolucaoCameraFrontal) {
		this.resolucaoCameraFrontal = resolucaoCameraFrontal;
	}
	public double getResolucaoCameraTraseira() {
		return resolucaoCameraTraseira;
	}
	public void setResolucaoCameraTraseira(double resolucaoCameraTraseira) {
		this.resolucaoCameraTraseira = resolucaoCameraTraseira;
	}
	
	
	@Override
	public String toString() {
		return "Celular [marca=" + marca + ", modelo=" + modelo + ", memoriaRam=" + memoriaRam + ", processador="
				+ processador + ", velocidadeProcessador=" + velocidadeProcessador + ", preco=" + preco
				+ ", tamanhoTela=" + tamanhoTela + ", memoriaArmazenamento=" + memoriaArmazenamento
				+ ", resolucaoCameraFrontal=" + resolucaoCameraFrontal + ", resolucaoCameraTraseira="
				+ resolucaoCameraTraseira + "]";
	}


	private String marca;
	private String modelo;
	private double memoriaRam;
	private String processador;
	private double velocidadeProcessador;
	private double preco;
	private double tamanhoTela;
	private int memoriaArmazenamento;
	private double resolucaoCameraFrontal;
	private double resolucaoCameraTraseira;
	

}
