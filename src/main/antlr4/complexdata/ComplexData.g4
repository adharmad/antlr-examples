// match one-or-more of the following pattern
// name, age, ssn, telephone number (format: (xxx)xxx-xxxx), date of birth (format: DD-MMM-YYYY)
grammar ComplexData;

startRule
	: ( NAME NUM NUM TEL DOB )+
	;
	
// date of birth
DOB: NUM HYPHEN UPPER_ALPHA UPPER_ALPHA UPPER_ALPHA HYPHEN NUM
	;

// Tel
TEL: LPAREN NUM RPAREN NUM HYPHEN NUM
	;

// match an upper/lower case name of any length
NAME: ( 'a'..'z' | 'A'..'Z' )+
	;

// match a decimal age of any length
// AGE & SSN
NUM: ( '0'..'9' )+
	;
	
UPPER_ALPHA: 'A'..'Z'
    ;

LPAREN: '(' 
    ;

RPAREN: ')'
    ;

HYPHEN: '-'
    ;

WS: (   ' '
        |   '\t'
        |   '\r' '\n'
        |   '\n' 
        ) -> skip
    ;

