					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  Registrador(registrador generico):           logica sequencial. Responsavel pela leitura de dados do BMarramento C(
  *											      inputC) para registrador interno(guarda). 
  *
  *                                               logica comBMinacional. Responsavel por dirigir o valor armazenado no registrador 
  *		                                          interno(guarda) para BMarramento adequado.(A ou BM). 
  *												  
  **********/  
module Registrador(
		input logic clk,
		input logic reset,
		
		input logic enaOutA,/*HaBMilita guarda para o BMarramento A*/
		input logic enaOutB,/*HaBMilita guarda para o BMarramento BM*/
		input logic enaIn,  /*HaBMilita inputC para o guarda*/
		input logic signed[31:0] inputC,
		
		output logic signed[31:0] A,
		output logic signed[31:0] BM
);

	logic signed [31:0]guarda;
    
    /*Parte sequencial do modulo*/
	always_ff @( posedge clk)begin
			if(reset) begin 
					guarda 	<= 32'b00000000000000000000000000000000;
			end else begin
				if(enaIn) begin				
					guarda <= inputC;	
				end/*enaBMleIn*/
			end	
	end
	
	/*Parte comBMinacional do modulo*/
	always_comb begin
	// Statements
			if(reset) begin 
				A 			= 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ;
				BM 			= 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ; 	
			end

			if(enaOutA)begin
					A = guarda;	
				end else begin
					A = 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ;
			end
			
			if(enaOutB)begin
					BM = guarda;	
				end else begin
					BM = 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ;
			end
	end
	
endmodule 