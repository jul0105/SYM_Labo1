# SYM Labo 1 

### 2.1 Langue de l’interface 

> De plus vous expliquerez, dans votre rapport, quel est l’intérêt de regrouper les chaînes de caractères dans un fichier XMLindépendantà côté des layouts.Vous expliquerez également commentorganiser les textes pour obtenir une application multi-langues (français, allemand, italien, langue par défaut: anglais)?Que se passe-t-il si une traduction est manquante dans la langue par défaut ou dans une langue supplémentaire?

### 2.2 Champs textuel de saisie 

> L’activité comporte deux champs textuels de saisie, le premier va être utilisé pour accueillir une adresse e-mail, le second pour un mot de passe. Nous pouvons constater deux petits problèmes:dans les deux cas le clavier virtuel va activer l’aide à la saisie (correcteur orthographique) ce qui n’est pas réellement adapté à la saisie d’un e-mail et encore moins pour un mot de passe. Etle champ pour le mot de passe ne cache pas la saisie effectuée, nous souhaiterions que seuls de ∙ ou des * soient affichés.Veuillez adapter la configuration de ces deux éléments d’interface utilisateur (UI) afin qu’ils proposent lecomportement décrit ci-dessus. (Indice: inputType)

Il suffit de changer `inputType` a `textPassword` pour le champs textuel (`main_email`) mot de passe. Et a `textEmailAdress` le `inputType` de `main_password`.

### 2.3 Mode paysage

> Si vous basculez votre téléphone en mode paysage, l’UI ne sera pas totalement adaptée et certains éléments,  comme  le  logo,  ne  seront  pas  affichés  correctement  (voir  Fig.  2a).  Votre  tâche  est  ici  de spécialiserle layout de cette première activité pour assurer un affichage adapté en mode paysage (voir un exemple sur la Fig.2b).

Ici on doit copier le `layout` `activity_main` dans un nouveau `layout` qu'on définit être comme paysage puis réarranger les éléments. 

![image-20201001104948078](/Users/robin/Document/heig/3eme/SYM/SYM_Labo1/image/image-20201001104948078.png)

## 3. Gestion des événement set mise à jour de l’interface utilisateur

### 3.1.Vérification du format de l’e-mail

> Lors de l’appui sur le bouton «Validate»,  dans  le  cas  où  les  deux champs  ontété  complétés,nous souhaitons dans un premier tempsvérifier que l’e-mail saisi soit valide (nous nous limiterons dans le cadre de ce laboratoire à vérifier la présence du caractère@), dans le cas contraire vous afficherezun message d’erreur à l’utilisateur sous la forme d’un Toast

### 3.2. Vérification du couple e-mail / mot de passe

> Si le format de l’e-mail saisi est valide, nous vérifierons ensuite si le couple (e-mail et mot de passe) saisi appartient à un utilisateur valide. Pour cela nous mettons à votre disposition, dans le code, la liste credentialscontenant  des  couples  valides.Si  le  couplesaisin’est pas valide, nous afficherons à l’utilisateur un message d’erreur sous la forme d’une fenêtre de dialogue2, si le couple est valide nous ouvrirons une nouvelle activité (dans la manipulation suivante).

## 4. Passage à une autre activité

### 4.1. Création et lancement de la nouvelle activité

> La première manipulation va être de définir cette nouvelle activité dans Android Studio. Une activité est principalement composée de deux éléments:son code (une classe héritant d’Activityou d’une de ses sous-classes, comme par exemple AppCompatActivity) et d’un fichier XMLdéfinissant son layout, l’activité devra être ensuite déclarée dans le fichier Manifestde l’application, sous peine de ne pas pouvoir être lancée. Android Studiopermet d’automatiser la création d’une nouvelle activité, toutefois selon le type choisi,le layout automatiquement généré sera très complexe.Une fois l’activité ajoutée dans l’IDE, vous mettrez en place le code permettant de la lancer lors du succès du login.



