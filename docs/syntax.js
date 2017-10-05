// vim:set ts=4 sw=4 tw=100 et:

window.find = document.querySelector.bind(document);

Diagram(
    NonTerminal('package-declaration', '#package-declaration')
    ,Optional(
        NonTerminal('import-declaration', '#import-declaration')
    )
    ,NonTerminal('class-declaration', '#class-declaration')
).addTo(find('.compilation-unit'));

Diagram(
    Terminal('package')
    ,NonTerminal('package-name', '#package-name')
    ,Terminal(';')
).addTo(find('.package-declaration'));

Diagram(
    NonTerminal('identifier', '#identifier')
    ,ZeroOrMore(Sequence(
        Terminal('.')
        ,NonTerminal('identifier', '#identifier')
    ))
).addTo(find('.package-name'));

Diagram(
    Terminal('import')
    ,Choice(0,
        Sequence(
            NonTerminal('package-name', '#package-name')
            ,Terminal('.')
            ,NonTerminal('identifier', '#identifier')
            ,Optional(Sequence(
                Terminal('as')
                ,NonTerminal('identifier', '#identifier')
            ))
        )
        ,Sequence(
            Terminal('static')
            ,NonTerminal('package-name', '#package-name')
            ,Terminal('.')
            ,NonTerminal('identifier', '#identifier')
            ,Terminal('.')
            ,Choice(
                0
                ,Terminal('*')
                ,Sequence(
                    NonTerminal('identifier', '#identifier')
                    ,Optional(Sequence(
                        Terminal('as')
                        ,NonTerminal('identifier', '#identifier')
                    ))
                )
            )
        )
    )
    ,Terminal(';')
).addTo(find('.import-declaration'));

Diagram(
    Terminal('class')
    ,NonTerminal('identifier', '#identifier')
    ,Terminal('{')
    ,Optional(Choice(0
        ,NonTerminal('member-declaration', '#member-variable-declaration')
        ,NonTerminal('method-declaration', '#method-declaration')
    ))
    ,Terminal('}')
    ,Terminal(';')
).addTo(find('.class-declaration'));
