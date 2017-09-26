// vim:set ts=4 sw=4 tw=100 et:

window.find = document.querySelector.bind(document);

Diagram(
    NonTerminal('package-declaration')
    ,NonTerminal('import-declaration')
    ,NonTerminal('class-declaration')
).addTo(find('.compilation-unit'));

Diagram(
    Terminal('package')
    ,NonTerminal('package-name')
    ,Terminal(';')
).addTo(find('.package-declaration'));
