					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
 *  DecodificadorB:(3 para 8) -   logica combinacional. Habilita um unico registrador
 *                                dirigir o valor armazendao em si proprio para o 
 *					              barramento B.
 *
 **********/
 
/******************* Interface do modulo *******************/
module DecodificadorB(	/**/
			
	input  wire [2:0] control,/**/
	
	output logic H2B, 
	output logic OPC2B,
	output logic TOS2B,
	output logic CPP2B,
	output logic LV2B,
	output logic SP2B,
	output logic PC2B,
	output logic MDR2B
			
);/*end interface ALU*/

/******************* Descricao do modulo *******************/
	always_comb begin
		// Statements	
		H2B    = 0; 
		OPC2B  = 0;
		TOS2B  = 0;
		CPP2B  = 0;
		LV2B   = 0;
		SP2B   = 0;
		PC2B   = 0;
		MDR2B  = 0;

		case(control)
			0 : H2B    = 1;
			1 : OPC2B  = 1;
			2 : TOS2B  = 1;
			3 : CPP2B  = 1;
			4 : LV2B   = 1;
			5 : SP2B   = 1;
			6 : PC2B   = 1;
			7 : MDR2B  = 1;
		endcase 
	end

endmodule			
			