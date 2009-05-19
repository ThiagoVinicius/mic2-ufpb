					/*********************************************
					 *	   UNIVERSIDADE  FEDERAL  DA  PARAIBA    *
					 *		 ARQUITETURA DE COMPUTADORES II      *
					 *	    	        						 *
					 *                   MIC				     *
					 *											 *
					 *	  ALUNO: LUCAS GAMBARRA  MAT:10711005    *
					 *********************************************/
 
 /**********
  *  MBR(registrador de ): logica sequencial. Responsavel pela leitura de dados da memoria principal(inMemPrinc) 
  *                        para registrador interno(MBR_Reg). 
  *
  *                        logica combinacional. Responsavel por dirigir o valor armazenado no registrador 
  *		                   interno(MBR_Reg) para barramento adequado.(A ou memoria principal). 
  *												  
  **********/ 
module MBR(
    input logic enaToA,
    input logic toSigned,/*Quando alto deve ser feita a extensao de sinal*/
    input logic reset,
    input logic clk,
    input logic FETCH,/*Quando alto  indica que havera dado valido(inMBR) na proxima borda de subida de clk*/
    
    input logic signed [7:0]inMBR,
    
    output logic unsigned[7:0]MBR2MPC,
    output logic signed [3:0][7:0] saidaMBR 
    
);

	logic signed   [7:0]MBR_Reg = 8'b00000000;
	logic unsigned leNaProximaSubida = 1'b0;/*Quando alto indica que na proxima borda de subida do clock havera um dado valido para ser 
	                                lido chegando da memoria*/

	always_ff @ (posedge clk) begin 
		if(reset)begin
			MBR_Reg  		  <=  8'b00000000;
			leNaProximaSubida <= 1'b0;
        end else begin        
			if(leNaProximaSubida == 1'b1)begin
				MBR_Reg           <= inMBR;
				if(FETCH)begin
					leNaProximaSubida <=1'b1;
				end else begin
					leNaProximaSubida <=1'b0;
				end
			end	else begin
				if(FETCH) begin
					leNaProximaSubida <= 1'b1;
				end 
			end
		end 
	end/*always_ff*/
		
	
	always_comb  begin 
		if(reset)begin
			saidaMBR[0][7:0] = 8'bZZZZZZZZ;
			saidaMBR[1][7:0] = 8'bZZZZZZZZ;
			saidaMBR[2][7:0] = 8'bZZZZZZZZ;
			saidaMBR[3][7:0] = 8'bZZZZZZZZ;	
		end else begin/*reset*/
			if(enaToA) begin
				saidaMBR[0][7:0] = MBR_Reg;
				if(toSigned)begin/*Extensao do sinal*/
					if(MBR_Reg[7])begin 
						saidaMBR[1][7:0] = 8'b11111111; 
						saidaMBR[2][7:0] = 8'b11111111;
						saidaMBR[3][7:0] = 8'b11111111;
					end else begin
						saidaMBR[1][7:0] = 8'b00000000; 
						saidaMBR[2][7:0] = 8'b00000000;
						saidaMBR[3][7:0] = 8'b00000000;
					end
					
				end else begin/*Sem extensao*/
					saidaMBR[1][7:0] = 8'b00000000; 
					saidaMBR[2][7:0] = 8'b00000000;
					saidaMBR[3][7:0] = 8'b00000000;
				end/*toSigned*/
			end else begin
					saidaMBR[0][7:0] = 8'bZZZZZZZZ;
					saidaMBR[1][7:0] = 8'bZZZZZZZZ; 
					saidaMBR[2][7:0] = 8'bZZZZZZZZ;
					saidaMBR[3][7:0] = 8'bZZZZZZZZ;
			end/*enaToA*/ 
		end/*reset*/	
		
		MBR2MPC = MBR_Reg;	
	end/*always_ff*/					
endmodule
