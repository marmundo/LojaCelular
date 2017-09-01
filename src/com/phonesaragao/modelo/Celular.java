package com.phonesaragao.modelo;

public class Celular {

	private int id;
	private String marca;
	private String modelo;
	private double ram;
	private String processador;
	private double velocidade_processador;
	private double preco;
	private double tela;
	private int armazenamento;
	private double camera_frontal;
	private double camera_traseira;
	private String url_img;

	public Celular() {
	}

	public Celular(int id, String marca, String modelo, double ram, String processador, double velocidade_processador, double preco,
			double tela, int armazenamento, double camera_frontal, double camera_traseira, String url_img) {

		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
		this.processador = processador;
		this.velocidade_processador = velocidade_processador;
		this.preco = preco;
		this.tela = tela;
		this.armazenamento = armazenamento;
		this.camera_frontal = camera_frontal;
		this.camera_traseira = camera_traseira;
		this.url_img = url_img;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public double getVelocidade_processador() {
		return velocidade_processador;
	}

	public void setVelocidade_processador(double velocidade_processador) {
		this.velocidade_processador = velocidade_processador;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTela() {
		return tela;
	}

	public void setTela(double tela) {
		this.tela = tela;
	}

	public int getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}

	public double getCamera_frontal() {
		return camera_frontal;
	}

	public void setCamera_frontal(double camera_frontal) {
		this.camera_frontal = camera_frontal;
	}

	public double getCamera_traseira() {
		return camera_traseira;
	}

	public void setCamera_traseira(double camera_traseira) {
		this.camera_traseira = camera_traseira;
	}
	
	public String getUrl_img() {
		return url_img;
	}

	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + "\nModelo: " + modelo + "\nRAM: " + ram + "\nProcessador: " + processador
				+ "\nVelocidade do processador: " + velocidade_processador + "\nPreço: R$" + preco + "\nTela: " + tela
				+ "\nArmazenamento: " + armazenamento + "\nCâmera Frontal: " + camera_frontal + "\nCâmera Traseira: "
				+ camera_traseira;
	}

}
