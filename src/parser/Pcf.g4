grammar Pcf;

// regle syntaxique
term: NUMBER                            # Number
   | term OP1 term                      # BinaryTerm1
   | term OP2 term                      # BinaryTerm2
   | 'ifz' term 'then' term 'else' term # IfZero
   | '(' term ')'                       # ParTerm
   | 'let' ID '=' term 'in' term        # Let
   | ID                                 # Var
   | 'fun' ID '->' term                 # Fun
   | term term                          # App
   ;

// regle lexicale
NUMBER: '0' | [1-9][0-9]* ;
ID: [a-z][a-z0-9]*;
OP1:   '*' | '/' ;
OP2:   '+' | '-' ;
WS: [ \r\t\n]+ -> skip;
