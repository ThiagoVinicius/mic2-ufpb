					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  FETCH_MEM:  apenas simula uma memoria para fetch
  *												  
  **********/ 
	
module FETCH_MEM(
	input  wire [31:0] PC_M,/*Endereco da memoria*/
	input  wire Fetch,
	input  wire clk_fecth,
	input  wire reset_mem_fecth,
	output logic [7:0] out_MBR 
);


logic [11:0][7:0]memoria_Fetch = {	//8'b00000011
									8'b00000011,/*iadd*/
									8'b00000110,/*isub*/
									8'b00010111,/*ifeq1*/
									8'b00010111,/*23 =>101*/
									8'b00001100,
									8'b00010101,/*21 =>100*/
									8'b00001100,
									8'b00011110,/*30 => 3*/
									8'b00001100,
									8'b00011101,/*29 => 2*/
									8'b00001100,
									8'b00000000};

logic [7:0] Reg_int_f;

// This construct should be used to infer sequential logic such as
// registers and state machines.
	always_ff@(negedge clk_fecth)
	begin
		// Statements
		if(reset_mem_fecth)begin
			Reg_int_f <= 8'b00000000;
		end else begin    
			if(Fetch) begin
				Reg_int_f <= memoria_Fetch[PC_M][7:0];
			end     
		end
		
	end

	// This construct should be used to infer purely combinational logic.
	always_comb
	begin
		// Statements
		if(reset_mem_fecth)begin
			out_MBR = 8'b00000000;
		end else begin
			out_MBR = Reg_int_f;
		end
	end
endmodule