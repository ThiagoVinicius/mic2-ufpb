					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  DecodificadorA(4 para 8): -   logica combinacional. Habilita um unico registrador
  *                                dirigir o valor armazendao em si proprio para o 
  *					              barramento A.
  **********/


/******************* Interface do modulo *******************/
module DecodificadorA(	/**/
				
		input  wire unsigned [3:0] control,/**/ 
		
		output logic H2A, 
		output logic OPC2A,
		output logic TOS2A,
		output logic CPP2A,
		output logic LV2A,
		output logic SP2A,
		
		output logic MBR2,
		output logic MBR,
		
		output logic MBRE,/*Indica se vai haver extensao de sinal caso um dos MBR's seja habilitado para saida. 
							Apenas um bit e' necessario visto que nao faz sentido habilitar os dois MBR's de 
							uma so vez*/
		output logic MDR2A
				
	);



// This construct should be used to infer purely combinational logic.
always_comb

	begin
		// Statements	
		H2A    = 0; 
		OPC2A  = 0;
		TOS2A  = 0;
		CPP2A  = 0;
		LV2A   = 0;
		SP2A   = 0;
		MBR2   = 0; 
	    MBR    = 0;
		MBRE   = 0;
		MDR2A  = 0;
		case(control)
			0 : H2A    = 1;
			1 : OPC2A  = 1;
			2 : TOS2A  = 1;
			3 : CPP2A  = 1;
			4 : LV2A   = 1;
			5 : SP2A   = 1;
		    
		    6 : MBR2   = 1;/*Sem extensao de sinal*/
		    
		    7 :begin
					MBR2   = 1;
					MBRE   = 1;/*Com extensao de sinal*/ 
		       end
              		    
		    8 : MBR    = 1;/*Sem extensao de sinal*/
		    9 :begin 
					MBR    = 1;
					MBRE   = 1;/*Com extensao de sinal*/ 
		       end
		    10:MDR2A = 1;    
			default: MDR2A = 0;/*11 e demais*/ 
		endcase 
	end
endmodule			
			