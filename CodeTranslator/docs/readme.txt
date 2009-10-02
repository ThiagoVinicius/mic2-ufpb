Code Translator 0.1
Por Erisvaldo Júnior
Site: http://erisvaldojunior.com

	INSTRUÇÕES DE USO

Code Translator é um "tradutor" de linguagens de alto nível para linguagens de baixo nível, tais como Assembly 80x86 e IJVM. No momento, Code Translator é capaz de interpretar uma única linguagem de alto nível, com sintaxe similar ao Pascal. Os detalhes dessa linguagem estão expostos a seguir.

Instruções: PROGRAM, VAR, BEGIN, END, IF/ENDIF e WHILE/ENDWHILE. 
Operadores: +, -, *, /, =, >, <, &, |.

A estrutura básica de um programa é:

PROGRAM

VAR {variáveis}

BEGIN

END;

O ponto e vírgula após cada instrução é opcional. A seguir, um exemplo completo:

PROGRAM

VAR i, j, k;

BEGIN

i = j + k;

IF (i = 3)
  k = 0;
ELSE
  j = j - 1;
ENDIF

END;

Após concluído o código em alto nível, basta pressionar F5 para gerar o equivalente em 80x86 e F6 para o equivalente em IJVM.

Qualquer dúvida, entrar em contato através do e-mail: contato@erisvaldojunior.com . Obrigado!  