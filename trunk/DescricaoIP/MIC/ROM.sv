					/*********************************************S
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBMA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBMARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  ROM:  apenas simula uma memoria para ROM
  *												  
  **********/ 
module ROM(
//	input  logic unsigned [38:0]  MICRO,
	input [8:0] MPC,
	input clk,
	input logic reset,
	input logic READ,/*Nesse caso vai estar sempre ativo*/	
		
	/****
	 Cada uma das saidas seguintes definram o funcionamento da proxima
	 */
	output logic [8:0]Next_ADDR,
	output logic [2:0]JAM,
	output logic [5:0]ALU,
	output logic [7:0]DESL_R,
	output logic [3:0]A,
	output logic [2:0]B,
	output logic enaMAR,
	output logic enaMDR,
	output logic enaPC,
	output logic enaSP,
	output logic enaLV,
	output logic enaCPP,
	output logic enaTOS,
	output logic enaOPC,
	output logic enaH,
	output logic [2:0]MEM,
	output logic [38:0] q1	//so para testes
);

	wire [44:0] sub_wire0;
	wire [44:0] q = sub_wire0[44:0];

	altsyncram	altsyncram_component (
				.clock0 (clk),
				.address_a (MPC),
				.q_a (sub_wire0),
				.aclr0 (1'b0),
				.aclr1 (1'b0),
				.address_b (1'b1),
				.addressstall_a (1'b0),
				.addressstall_b (1'b0),
				.byteena_a (1'b1),
				.byteena_b (1'b1),
				.clock1 (1'b1),
				.clocken0 (1'b1),
				.clocken1 (1'b1),
				.clocken2 (1'b1),
				.clocken3 (1'b1),
				.data_a ({39{1'b1}}),
				.data_b (1'b1),
				.eccstatus (),
				.q_b (),
				.rden_a (1'b1),
				.rden_b (1'b1),
				.wren_a (1'b0),
				.wren_b (1'b0));
	defparam
		altsyncram_component.clock_enable_input_a = "BYPASS",
		altsyncram_component.clock_enable_output_a = "BYPASS",
		altsyncram_component.init_file = "memory.mif",
		altsyncram_component.intended_device_family = "Stratix II",
		altsyncram_component.lpm_hint = "ENABLE_RUNTIME_MOD=NO",
		altsyncram_component.lpm_type = "altsyncram",
		altsyncram_component.numwords_a = 512,
		altsyncram_component.operation_mode = "ROM",
		altsyncram_component.outdata_aclr_a = "NONE",
		altsyncram_component.outdata_reg_a = "UNREGISTERED",
		altsyncram_component.widthad_a = 9,
		altsyncram_component.width_a = 44,
		altsyncram_component.width_byteena_a = 1;													
										
logic [44:0] NEXT_INSTRUCT =44'b0 ;// = 39'b000000000000000000000000000000000000000;


// This construct should be used to infer sequential logic such as
// registers and state machines.
	always_ff@(negedge clk)
	begin
		// Statements
		if(reset)begin //No reset devemos configurar para fazer nada mais ainda falta definir a instrucao
			NEXT_INSTRUCT <= 44'b000000000000000000000000000000000000000000000;//39'b000000001001000000000001001001000000000;
		end else begin
			if(READ) begin
			    //NEXT_INSTRUCT <= MICROPROGRAMA[MPC][38:0];			    
			    NEXT_INSTRUCT <= q[44:0];			    
			end
		end
	end
	
	// This construct should be used to infer purely combinational logic.
always_comb
begin

		
	// Statements
			    Next_ADDR 	= NEXT_INSTRUCT[44:36];
				JAM 	  	= NEXT_INSTRUCT[35:33];
				ALU 		= NEXT_INSTRUCT[32:27];
				DESL_R 		= NEXT_INSTRUCT[26:19];		
				A 			= NEXT_INSTRUCT[18:15];
				B 			= NEXT_INSTRUCT[14:12];
				enaMAR      = NEXT_INSTRUCT[11];
				enaMDR      = NEXT_INSTRUCT[10];
				enaPC      	= NEXT_INSTRUCT[9];
				enaSP      	= NEXT_INSTRUCT[8];
				enaLV     	= NEXT_INSTRUCT[7];
				enaCPP     	= NEXT_INSTRUCT[6];
				enaTOS      = NEXT_INSTRUCT[5];
				enaOPC      = NEXT_INSTRUCT[4];
				enaH      	= NEXT_INSTRUCT[3];			
				MEM 		= NEXT_INSTRUCT[2:0];
				q1          = NEXT_INSTRUCT[38:0];  //so para testes
	
end

	
endmodule
