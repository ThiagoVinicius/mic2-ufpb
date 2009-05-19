module SelectMem(
	input logic 	MEM[2:0],
	output logic Read,Fetch,Write
);

// This construct should be used to infer purely combinational logic.
always_comb
begin
	// Statements
	Write = MEM[2];
	Read  = MEM[1];
	Fetch = MEM[0];
end

endmodule