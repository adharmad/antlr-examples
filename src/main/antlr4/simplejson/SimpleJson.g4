// grammar for simple json
// Only support string and nested attributes such as:
// {
//      "attr1" : "val1",
//      "attr2" : "val2",
//      "attrjson1" : {
//          "attr3" : "val3",
//          "attr4" : "val4"
//      },
//      "attr5" : "val5"
// }
grammar SimpleJson;

json
	: '{' elem (',' elem)* '}'
	;

elem
    : '"' ID '"'  ':' json
    | '"' ID '"'  ':' '"' ID '"'
    ;


ID: [a-zA-Z0-9]+
	;

WS: (   ' '
        |   '\t'
        |   '\r' '\n'
        |   '\n' 
        ) -> skip
    ;
