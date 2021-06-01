// vim:set ts=4 sw=4 tw=100 et:

window.find = document.querySelector.bind(document);

function HrefNonTerminal(text) {
    return NonTerminal(text, '#' + text);
}

Diagram(
    HrefNonTerminal('package')
    ,ZeroOrMore(
        HrefNonTerminal('import')
    )
    ,OneOrMore(Choice(0
        ,HrefNonTerminal('struct')
        ,HrefNonTerminal('class')
    ))
).addTo(find('.compilation-unit'));

Diagram(
    Terminal('[a-zA-Z_]')
    ,ZeroOrMore('[a-zA-Z_0-9]')
).addTo(find('.identifier'));

Diagram(
    HrefNonTerminal('identifier')
    ,ZeroOrMore(Sequence(
        Terminal('.')
        ,HrefNonTerminal('identifier')
    ))
).addTo(find('.fully-qualified-name'));

Diagram(
    Terminal('package')
    ,HrefNonTerminal('fully-qualified-name')
    ,Terminal(';')
).addTo(find('.package'));

Diagram(
    Terminal('import')
    ,Optional(Terminal('static'))
    ,HrefNonTerminal('fully-qualified-name')
    ,Optional(Sequence(
        Terminal('as')
        ,HrefNonTerminal('identifier')
    ))
    ,Terminal(';')
).addTo(find('.import'));

Diagram(
    HrefNonTerminal('visibility')
    ,Terminal('struct')
    ,HrefNonTerminal('identifier')
    ,Terminal('{')
    ,ZeroOrMore(Choice(0
        ,HrefNonTerminal('member')
        ,HrefNonTerminal('method')
    ))
    ,Terminal('}')
    ,Terminal(';')
).addTo(find('.struct'));

Diagram(
    HrefNonTerminal('visibility')
    ,Terminal('class')
    ,HrefNonTerminal('identifier')
    ,Terminal('{')
    ,Optional(OneOrMore(Choice(0
        ,HrefNonTerminal('member')
        ,HrefNonTerminal('method')
    )))
    ,Terminal('}')
    ,Terminal(';')
).addTo(find('.class'));

Diagram(
    HrefNonTerminal('visibility')
    ,Optional(Terminal('static'))
    ,Optional(Terminal('const'))
    ,HrefNonTerminal('identifier')
    ,Optional(Sequence(
        Terminal('=')
        ,HrefNonTerminal('expression')
    ))
).addTo(find('.member'));

Diagram(
    HrefNonTerminal('visibility')
    ,Optional(Terminal('static'))
    ,HrefNonTerminal('return-value')
    ,Terminal('(')
    ,Optional(HrefNonTerminal('argument-list'))
    ,Terminal(')')
    ,Terminal('{')
    ,Optional(HrefNonTerminal('statement-list'))
    ,Terminal('}')
    ,Optional(Terminal('const'))
).addTo(find('.method'));

Diagram(
    Optional(Choice(0
        ,Terminal('public')
        ,Terminal('protected')
        ,Terminal('private')
    ))
).addTo(find('.visibility'));
