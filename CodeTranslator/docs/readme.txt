Code Translator 0.1
Por Erisvaldo J�nior
Site: http://erisvaldojunior.com

	INSTRU��ES DE USO

Code Translator � um "tradutor" de linguagens de alto n�vel para linguagens de baixo n�vel, tais como Assembly 80x86 e IJVM. No momento, Code Translator � capaz de interpretar uma �nica linguagem de alto n�vel, com sintaxe similar ao Pascal. Os detalhes dessa linguagem est�o expostos a seguir.

Instru��es: PROGRAM, VAR, BEGIN, END, IF/ENDIF e WHILE/ENDWHILE. 
Operadores: +, -, *, /, =, >, <, &, |.

A estrutura b�sica de um programa �:

PROGRAM

VAR {vari�veis}

BEGIN

END;

O ponto e v�rgula ap�s cada instru��o � opcional. A seguir, um exemplo completo:

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

Ap�s conclu�do o c�digo em alto n�vel, basta pressionar F5 para gerar o equivalente em 80x86 e F6 para o equivalente em IJVM.

Qualquer d�vida, entrar em contato atrav�s do e-mail: contato@erisvaldojunior.com . Obrigado!  