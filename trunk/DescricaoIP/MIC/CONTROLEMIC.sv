					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  CONTROLEMIC: determina proxima instrucao a ser executada.  
  *												  
  **********/ 
module CONTROLEMIC(

	input logic N,/*N da ULA*/
    input logic Z,/*Z da ULA*/
    input logic [7:0]inMBR,/*MBR do DATA_PATH*/
    input logic [8:0] ADDR,/*Next Adress da instrucao*/
	input logic [2:0] JNZC,/*2 <= N || 1 <= Z  || 0 <= C */
	input logic clk,/*Possivel clk*/	
	
	output logic [8:0] outMPC
	
	);

	logic reg_Z;
	logic reg_N;

	// This construct should be used to infer sequential logic such as
	// registers and state machines.
	always_ff@(posedge clk)
	begin
		// Statements
		reg_Z <= Z;
		reg_N <= N;
	end

	//always_ff@(negedge clk)
	always_comb begin
		// Statements
		if(JNZC[0])begin
			outMPC[8]   =  ADDR[8];
			outMPC[7:0] =  ADDR[7:0] | inMBR;
		end else begin /*JNZC*/
			outMPC[8]   = ( JNZC[1] & Z) | ( JNZC[2] & N) | ADDR[8];
			outMPC[7:0] = ADDR[7:0];
		end/*JNZC*/
		
	end
endmodule