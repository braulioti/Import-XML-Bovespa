# [Import XML Bovespa v1.0.0](https://github.com/braulioti/Import-XML-Bovespa)
### Import XML Bovespa

[![Twitter: @braulio_info](https://img.shields.io/badge/contact-@braulio_info-blue.svg?style=flat)](https://twitter.com/braulio_info)
[![Build Status](https://travis-ci.org/braulioti/Import-XML-Bovespa.svg?branch=master)](https://travis-ci.org/braulioti/Import-XML-Bovespa)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5a8e5c9dc58149248f89d9530514e853)](https://www.codacy.com/app/braulioti/Import-XML-Bovespa?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=braulioti/Import-XML-Bovespa&amp;utm_campaign=Badge_Grade)

Serviço de importação de dados de ações com o objetivo de capturar informações referente aos papéis das empresas da Bovespa

Import XML Bovespa é criado e mantido por [Bráulio Figueiredo](http://braulioti.com.br).
Novas atualizações do projeto podem ser acompanhadas através do twitter:
[@braulio_info](http://twitter.com/braulio_info).

## Changelog

- [1.0.0 Importado dados do arquivo XML para o banco de dados](https://github.com/braulioti/Import-XML-Bovespa)

## Versionamento

Import XML Bovespa utiliza as diretrizes do "Semantic Versioning" sempre que possível.
As atualizações são numeradas da seguinte forma:

`<maior>.<menor>.<correção>`

Construído sobre as seguintes diretrizes:

* Quebra de compatibilidade com a versão anterior será atualizado em "maior"
* Novas implementações e funcionalidades em "menor"
* Correção de erros em "correção"

Para mais informações sobre o SemVer, por favor visite http://semver.org.

## Autor
- Email: braulio@braulioti.com.br
- Twitter: http://twitter.com/braulio_info
- GitHub: https://github.com/braulioti
- Website: http://braulioti.com.br

## Usando o projeto

- Execute o arquivo script_0.1.0.sql no seu banco de dados PostgreSQL
- Extraia os arquivos zip que você baixou do site da Bovespa para o seu computador
- Execute o seguinte comando na pasta onde os arquivos XML estão guardados:

`java -jar import_xml_bovespa-0.1.0.jar host:port/database username password script_folder`