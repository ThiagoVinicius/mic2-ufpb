					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  Deslocador: - logica combinaciobal.           
  *												  
  **********/ 

module Deslocador(	/**/
		input wire signed[31:0] E,
		input wire [1:0]Deslc, /*SLL8 (Shift Left Logical) e SRA1(Shift Right Arithmatic)*/
		output logic signed[31:0] R
	);/*end interface ALU*/

	always_comb begin
		// Statements
			
			case(Deslc)
				1: 		R = E  << 8;/*bitwise left-shift de um byte. Why?*/
				2: 		R = E  >>> 1;/*Arithmetic left-shift*/
				3:      R = E  << 1;
				default:R = E;/*10 e demais*/
			endcase
	end
endmodule			
			