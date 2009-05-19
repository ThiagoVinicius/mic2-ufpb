/**********
 *  Decodificador 3 para 8:
 *  Habilta qual entrada sera apita a entrar no barranento b
 *
 *
 *
 **********/

module DecodificadorC(	/**/
			
	input  logic [3:0] controlC,/**/	
	output  logic C2MAR,  	
	output  logic C2MDR, 	
	output  logic C2PC, 	
	output  logic C2SP,	
	output  logic C2LV,	
	output  logic C2CPP, 
	output  logic C2TOS,
	output  logic C2OPC,
	output  logic C2H
			
);/*end interface ALU*/



	
// This construct should be used to infer sequential logic such as
// registers and state machines.

always_comb
	begin
		// Statements	
		C2MAR 	=0;  	
		C2MDR	=0; 	
		C2PC	=0; 	
		C2SP	=0;	
		C2LV	=0;	
		C2CPP	=0; 
		C2TOS	=0;
		C2OPC	=0;
		C2H		=0;

		case(controlC)
			0 : 	C2MAR  	= 1;
			1 : 	C2MDR  	= 1;
			2 : 	C2PC   	= 1;
			3 : 	C2SP 	= 1;
			4 : 	C2LV  	= 1;
			5 : 	C2CPP  	= 1;
			6 : 	C2TOS   = 1;
		    7 : 	C2OPC   = 1;
		    8 :    	C2H     = 1;   
			default:C2H    	= 0;/*Faz nada*/
		endcase 
	end

endmodule			
			