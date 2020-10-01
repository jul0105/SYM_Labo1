# SYM Labo 1 

### 2.1 Langue de l’interface 

> De plus vous expliquerez, dans votre rapport, quel est l’intérêt de regrouper les chaînes de caractères dans un fichier XMLindépendantà côté des layouts.Vous expliquerez également commentorganiser les textes pour obtenir une application multi-langues (français, allemand, italien, langue par défaut: anglais)?Que se passe-t-il si une traduction est manquante dans la langue par défaut ou dans une langue supplémentaire?

### 2.2 Champs textuel de saisie 

> L’activité comporte deux champs textuels de saisie, le premier va être utilisé pour accueillir une adresse e-mail, le second pour un mot de passe. Nous pouvons constater deux petits problèmes:dans les deux cas le clavier virtuel va activer l’aide à la saisie (correcteur orthographique) ce qui n’est pas réellement adapté à la saisie d’un e-mail et encore moins pour un mot de passe. Etle champ pour le mot de passe ne cache pas la saisie effectuée, nous souhaiterions que seuls de ∙ ou des * soient affichés.Veuillez adapter la configuration de ces deux éléments d’interface utilisateur (UI) afin qu’ils proposent lecomportement décrit ci-dessus. (Indice: inputType)

Il suffit de changer `inputType` a `textPassword` pour le champs textuel (`main_email`) mot de passe. Et a `textEmailAdress` le `inputType` de `main_password`.

