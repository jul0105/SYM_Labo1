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

## 5. Navigation entre les activités 

> Nous souhaitons à présent ajouter une fonctionnalité permettant de créer de nouveaux comptes
> utilisateurs. Cette fonctionnalité prendra la forme d’une nouvelle activité, permettant de saisir et de
> valider une adresse e-mail et un mot de passe, ceux-ci seront transmis à l’activité principale lors du
> retour sur celle-ci.

### 5.1 Création et lancement d'une activité 

> Comme pour le point 4.1, vous allez commencer par définir une nouvelle activité et un layout associé.
> Cette activité, et son layout, sont très semblables à l’activité principale il est donc certainement
> possible de s’en inspirer ou même de réutiliser certains éléments. Cette activité permettra de saisir
> une adresse e-mail et un mot de passe, elle effectuera une validation de ceux-ci (sur la forme
> uniquement, comme pour le point 3.1, nous n’allons pas faire de vérifications additionnelles), et
> retournera le compte (couple e-mail / password) à l’activité principale qui l’ajoutera alors à la liste
> credentials . (Indice : Launching an activity for result).

### 5.2 Affichage d'une image 

> Sur l’activité principale, une image vectorielle est affichée sur le haut de l’activité. Nous souhaitons
> mettre une autre image sur l’activité d’inscription. Pour cela vous pouvez choisir une image sur
> Internet (PNG ou JPEG), la télécharger et l’inclure dans les ressources de l’application afin de pouvoir
> l’ajouter au layout. Dans quel(s) dossier(s) devons-nous ajouter cette image ? Veuillez décrire
> brièvement la logique derrière la gestion des ressources de type « image matricielle » sur Android.
> Quel intérêt voyez-vous donc à utiliser une image vectorielle ? Est-ce possible dans tous les cas ?

### 5.3 Factorisation du code

> Vous remarquerez les très nombreuses similarités entre ces deux activités : le code de vérification et
> certains éléments de l’interface graphique. Nous souhaitons factoriser ce code pour en faciliter sa
> maintenance. Veuillez mettre en place une factorisation « simple » du code de ces deux activités (en
> Kotlin ou Java), vous commenterez votre approche dans votre rapport. Vous discuterez également des
> possibilités de factoriser des layouts, sans forcément le réaliser.

### 5.4 Cycle de vie 

> Dans vos les trois activités, veuillez implémenter des sorties dans les logs pour les méthodes
> onCreate() , onStart() , onResume() , onPause() , onStop() , etc... qui marquent le cycle de vie d'une
> application Android. Décrivez brièvement à quelles occasions ces méthodes sont invoquées. Vous
> expliquerez aussi l’enchainement de ces appels lorsque l’on passe d’une activité à une autre. Comme
> pour le point 5.3, il est certainement possible de factoriser votre code pour réaliser cette étape

Les activités dans le système sont gérées de la même manière qu'une stack. Lorsqu'une activité démarre elle est généralement placée au sommet de la pile et est considérée comme l'activité en cours, l'activité précédente est placée en dessous de celle nouvellement créé. 

`onCreate()` : Cette méthode est appelée au début du cycle de vie de l'activité, cela correspond à sa construction. (start **entire lifetime**)

`onStart()` : C'est le moment ou l'activité devient visible dans l'application même si celle-ci n'est pas nécessairement au premier plan. (start **visible lifetime**)

`onResume()` : C'est le moment ou l'activité apparaît au premier plan. (start **foreground lifetime**)

`onPause()` : L'activité n'apparaît plus au premier plan. (end **foreground lifetime**)

`onStop()` : L'activité n'a plus de comportement visible sur l'écran. (end **visible lifetime**) 

![image-20201004100158814](image/image-20201004100158814.png)

[source]: https://developer.android.com/reference/android/app/Activity

