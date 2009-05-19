					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  MAR:(registrador de endereco de memoria) -   logica sequencial. Lanca endereco de palavra de  memoria vindo
  *												  pelo barramento C(enaIn alto e posedge clk) na memoria princiapal
  *                                               com a qual tem comunicacao direta.
  *												  
  **********/
module MAR(
		input logic clk,
		input logic reset,
		
		input logic enaIn, /*Habilita entrada pelo barramento C*/			
		
		input logic signed[31:0] inputC,/*Entrada do barramento C*/
		
		output logic unsigned[31:0] outMemPrinc/*Saida para memoria principal*/
);

	always_ff @( posedge clk)begin
			if(reset) begin 
				outMemPrinc <= 32'b00000000000000000000000000000000;
			end else begin
				if(enaIn) begin				
					outMemPrinc <= inputC;	
				end/*enableIn*/
			end	
	end
	
	
endmodule 