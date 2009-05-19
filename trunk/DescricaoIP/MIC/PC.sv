					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  PC(contador de programa):logica sequencial. Responsavel pela leitura de dados  do barramento C(
  *							  inputC). 
  *
  *                           logica combinacional. Responsavel por dirigir o valor armazenano no registrador 
  *		                      interno(guarda) para barramento adequado.(B ou memoria principal). 
  **********/   
	
	
	module PC(
		input logic clk,
		input logic reset,
		
		input logic enaOutB,/*Habilita registrador interno(guarda) para o barramento B*/
		input logic enaIn,  /*Habilita inputC para registrador interno(guarda)*/			
		
		input logic signed[31:0] inputC,
		
		output logic signed[31:0] B,
		output logic unsigned[31:0] outMemPrinc/*Saida da memoria principal*/
);


	logic signed [31:0]guarda;

	always_ff @( posedge clk)begin
			if(reset) begin 
				guarda <= 32'b00000000000000000000000000000000;
			end else begin
				if(enaIn) begin				
					guarda <= inputC;	
				end/*enableIn*/
			end	
	end
	
	// This construct should be used to infer purely combinational logic.
	always_comb
	begin
	// Statements
			if(reset) begin 
				B 			= 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ; 
				outMemPrinc = 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ;		
			end
			
			if(enaOutB)begin
					B = guarda;	
				end else begin
					B = 32'bZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ;
			end
	
			outMemPrinc = guarda;/*Saida para memoria sempre esta ativa*/
	
	end
	
endmodule 