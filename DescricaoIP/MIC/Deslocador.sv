					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA				 *
					 *           JOAO JANDUY B. PRIMO			 *
					 *           TURMA 2009.2       			 *
					 *********************************************/
 
 /**********
  *  Deslocador: - logica combinaciobal.           
  *												  
  **********/ 

module Deslocador(	/**/
		input wire signed[31:0] E,
		input wire [7:0]control, 
		
		output logic signed[31:0] R
	);/*end interface ALU*/

logic [31:0] B;
logic [31:0] C;

always begin
	C = E;

	if(control[7] == 1) begin // se o deslocamento for em barril
	
		if( control[6] == 1 ) begin // se for para a esquerda
	
			if( control[0] == 1 ) begin
				B[31:1] = C[30:0];
				B[0] = C[31];
				C = B;
			end
			if( control[1] == 1 ) begin
				B[31:2] = C[29:0];
				B[1:0] = C[31:30];
				C = B;
			end
			if( control[2] == 1 ) begin
				B[31:4] = C[27:0];
				B[3:0] = C[31:28];
				C = B;
			end
			if( control[3] == 1 ) begin
				B[31:8] = C[23:0];
				B[7:0] = C[31:24];
				C = B;
			end
			if( control[4] == 1 ) begin
				B[31:16] = C[15:0];
				B[15:0] = C[31:16];
				C = B;
			end
			
		end
		
		/*
		else begin // se for para a direita
		
			if( control[3] == 1 ) begin
				B[30:0] = C[31:1];
				B[31] = C[0];
				C = B;
			end
			if( control[4] == 1 ) begin
				B[29:0] = C[31:2];
				B[31:30] = C[1:0];
				C = B;
			end
			if( control[5] == 1 ) begin
				B[27:0] = C[31:4];
				B[31:28] = C[3:0];
				C = B;
			end
			if( control[6] == 1 ) begin
				B[23:0] = C[31:8];
				B[31:24] = C[7:0];
				C = B;
			end
			if( control[7] == 1 ) begin
				B[15:0] = C[31:16];
				B[31:16] = C[15:0];
				C = B;
			end		
		
		end
		*/
		
		R = B;
		
	end
	else begin // se o deslocamento nao for em barril
	
		if( control[6] == 1 ) begin // se for para a esquerda
			
			if( control[5] == 1) begin // se nao mantem o sinal			
				R = E << control[7:3];			
			end
			else begin // se mantem o sinal
				R[30:0] = C[30:0] << control[7:3];	
				R[31] = C[31];
			end
			
		end
		else begin // se for para a direita
		
			if( control[5] == 1) begin // se nao mantem o sinal
				R = E >> control[7:3];
			end
			else begin // se mantem o sinal
				R[30:0] = C[30:0] >> control[7:3];
				R[31] = C[31];
			end
		
		end
	
	end

end 
endmodule			
			