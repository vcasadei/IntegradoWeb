$(document).ready(function() {
    var aid = window.location.search.substring(1).split('?')[0].split('=')[1];

    $.ajax({
        type: "POST",
        url: "PesquisarArtigo",
        dataType: "json",
        data: {articleID: aid},
        cache: false
    }).done(function(data) {
        console.log(data);
        constroiInformacoes(data);
    });
    
});

function constroiInformacoes(json){
    var artContainer = document.getElementById('article-container');

    //titulo
    var titleBox = document.createElement('div');
    var hTitle = document.createElement('h2');
    var journal = document.createElement('p');

    var aux = document.createElement('b');

    titleBox.setAttribute('id','title-box');
    hTitle.setAttribute('id','title');
    journal.setAttribute('id','journal');
    
    hTitle.innerHTML = json.title;
    
    //setando journal
    aux.innerHTML = 'Revista: '
    journal.appendChild(aux);
    // aux.createTextNode(json.journal.title + ' 
    //     (Abreviação: '+json.journal.abbreviation+'), 
    //     ISSN: '+json.journal.issn+', Páginas: '+json.pagination+'');
    var journalString = json.journal.title;
    if (json.journal.abbreviation != undefined || 
            json.journal.abbreviation != null || json.journal.abbreviation.length !== 0){
        journalString = journalString + ' (Abreviação: '+json.journal.abbreviation+')';
    };
    journalString = journalString + '. ISSN: '+json.journal.issn;
    if (json.volume != undefined || 
            json.volume != null || (json.volume).length !== 0){
        journalString = journalString + '. Vol '+json.volume;
    };
    if (json.pagination != undefined || 
            json.pagination != null || (json.pagination).length !== 0){
        journalString = journalString + '. Páginas: '+json.pagination;
    };
    if (json.issue != undefined || 
            json.issue != null || (json.issue).length !== 0){
        journalString = journalString + '. Issue: '+json.issue;
    };
    var journalTextNode = document.createTextNode(journalString);
    journal.appendChild(journalTextNode);

    if ((json.pubDate).length !== 0){
        
        var dataPublicacao = document.createElement('p');
        var data = json.pubDate.split('-');
        data = data[2]+'/'+data[1]+'/'+data[0];
        dataPublicacao.appendChild(document.createTextNode('Artigo publicado em: '+data));
        journal.appendChild(dataPublicacao);
    };

    titleBox.appendChild(hTitle);
    titleBox.appendChild(journal);
    artContainer.appendChild(titleBox);
    //fim titulo

    //autor
    var authorBox = document.createElement('div');
    authorBox.setAttribute('id','author-box');    
    var aut = document.createTextNode('Autores: ');
    authorBox.appendChild(aut);

    var len = json.authorList.length;
    for (var i = 0; i < len; i++) {
        var authorName = document.createElement('h6');
        authorName.innerHTML = json.authorList[i].lastName + '. ' + json.authorList[i].foreName;
        authorBox.appendChild(authorName);

        if (i != len-1) {
            var separator = document.createElement('h5');
            separator.innerHTML = ', ';
            authorBox.appendChild(separator);
        };
    };

    artContainer.appendChild(authorBox);
    //fim autor

    //resumo
    var absBox = document.createElement('div');
    absBox.setAttribute('id','abstract-box');
    var absLabel = document.createElement('h3');
    absLabel.setAttribute('class','label');
    absLabel.innerHTML = 'Resumo:';
    var abs = document.createElement('p');
    abs.setAttribute('id','abstract');
    if (json.resumo == undefined || json.resumo == null || json.resumo.length === 0) {
        abs.innerHTML = 'Resumo não disponível'
    } else {
        abs.innerHTML = json.resumo;
    };

    absBox.appendChild(absLabel);
    absBox.appendChild(abs);

    artContainer.appendChild(absBox);
    //fim resumo
    
    //mesh
    var meshBox = document.createElement('div');
    meshBox.setAttribute('id','mesh-box');
    var meshLabel = document.createElement('h3');
    meshLabel.setAttribute('class','label');
    meshLabel.innerHTML = 'Termos Mesh: ';
    meshBox.appendChild(meshLabel);

    var len = json.meshList.length; 
    if (json.meshList == undefined || json.meshList ==null || len === 0){
        var meshName = document.createElement('h6');
        meshName.setAttribute('class','property-name');
        meshName.innerHTML = 'Nenhum termo mesh disponível';
        meshBox.appendChild(meshName);
    } else {

        for (var i = 0; i < len; i++) {
            var meshName = document.createElement('h6');
            meshName.setAttribute('class','property-name');

            meshName.innerHTML = json.meshList[i].meshDescriptor;
            meshBox.appendChild(meshName);

            if (i != len-1) {
                var separator = document.createElement('h5');
                separator.innerHTML = ', ';
                meshBox.appendChild(separator);
            };
        };
    };

    artContainer.appendChild(meshBox);
    //fim mesh

    //keyword
    var keywordBox = document.createElement('div');
    keywordBox.setAttribute('id','keyword-box');
    var keywordLabel = document.createElement('h3');
    keywordLabel.setAttribute('class','label');
    keywordLabel.innerHTML = 'Palavras-chave: ';
    keywordBox.appendChild(keywordLabel);

    var len = json.keywordList.length;
    if (json.keywordList == undefined || json.keywordList == null || len === 0){
        var keywordName = document.createElement('h6');
        keywordName.setAttribute('class','property-name');
        keywordName.innerHTML = 'Nenhuma palavra-chave disponível';
        keywordBox.appendChild(keywordName);
    } else {

        for (var i = 0; i < len; i++) {
            var keywordName = document.createElement('h6');
            keywordName.setAttribute('class','property-name');

            keywordName.innerHTML = json.keywordList[i].keywordName;
            keywordBox.appendChild(keywordName);

            if (i != len-1) {
                var separator = document.createElement('h5');
                separator.innerHTML = ', ';
                keywordBox.appendChild(separator);
            };
        };
    };

    artContainer.appendChild(keywordBox);
    //fim keyword

    //chemical
    var chemicalBox = document.createElement('div');
    chemicalBox.setAttribute('id','chemical-box');
    var chemicalLabel = document.createElement('h3');
    chemicalLabel.setAttribute('class','label');
    chemicalLabel.innerHTML = 'Substâncias químicas: ';
    chemicalBox.appendChild(chemicalLabel);

    var len = json.chemicalList.length;
    if (json.chemicalList == undefined || json.chemicalList == null || len === 0){
        var chemicalName = document.createElement('h6');
        chemicalName.setAttribute('class','property-name');
        chemicalName.innerHTML = 'Nenhuma substância disponível';
        chemicalBox.appendChild(chemicalName);
    } else {

        for (var i = 0; i < len; i++) {
            var chemicalName = document.createElement('h6');
            chemicalName.setAttribute('class','property-name');

            chemicalName.innerHTML = json.chemicalList[i].chemicalName;
            chemicalBox.appendChild(chemicalName);

            if (i != len-1) {
                var separator = document.createElement('h5');
                separator.innerHTML = ', ';
                chemicalBox.appendChild(separator);
            };
        };
    };

    artContainer.appendChild(chemicalBox);
    //fim chemical

    //publicationType
    var publicationBox = document.createElement('div');
    publicationBox.setAttribute('id','publication-box');
    var publicationLabel = document.createElement('h3');
    publicationLabel.setAttribute('class','label');
    publicationLabel.innerHTML = 'Tipos de publicação: ';
    publicationBox.appendChild(publicationLabel);

    var len = json.publicationTypeList.length;
    if (json.publicationTypeList == undefined || json.publicationTypeList == null || len === 0){
        var publicationType = document.createElement('h6');
        publicationType.setAttribute('class','property-name');
        publicationType.innerHTML = 'Nenhum tipo de publicação disponível';
        publicationBox.appendChild(publicationType);
    } else {

        for (var i = 0; i < len; i++) {
            var publicationType = document.createElement('h6');
            publicationType.setAttribute('class','property-name');

            publicationType.innerHTML = json.publicationTypeList[i].publicationType;
            publicationBox.appendChild(publicationType);

            if (i != len-1) {
                var separator = document.createElement('h5');
                separator.innerHTML = ', ';
                publicationBox.appendChild(separator);
            };
        };
    };

    artContainer.appendChild(publicationBox);
    //fim publicationType

};

