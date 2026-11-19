grammar Pcf;

// regle syntaxique
term: NUMBER                            # Number
   | ID                                 # Var
   | '(' term ')'                       # ParTerm
   | term term                          # App
   | term OP1 term                      # BinaryTerm1
   | term OP2 term                      # BinaryTerm2
   | 'ifz' term 'then' term 'else' term # IfZero
   | 'let' ID '=' term 'in' term        # Let
   | 'fun' ID '->' term                 # Fun
   | 'fix' ID term                      # Fix
   ;

// regle lexicale
NUMBER: '0' | [1-9][0-9]* ;
ID: [a-z][a-z0-9]*;
OP1:   '*' | '/' ;
OP2:   '+' | '-' ;
WS: [ \r\t\n]+ -> skip;
