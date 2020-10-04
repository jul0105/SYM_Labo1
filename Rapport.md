### 2.1. Langue de l'interface

Il faut ajouter un nouveau fichier de type "*Value Resource File*" dans le dossier *res/values* en l'appelant "strings.xml" et en ajoutant le paramètre "*Local = FR*". Ensuite, il faut copier tous les balises du fichier *strings.xml* anglais et traduire les textes. Android se chargera de sélectionner le bon fichier de langue en fonction des paramètres du système.

### 2.2. Champs textuels de saisie

Il faut définir l'*inputType* des deux champs de saisie. Pour le champs email il faut définir le type **textEmailAddress** et pour le champs mot de passe, il faut définir le type **textPassword**.

### 2.3. Mode paysage

Ajouter un nouveau fichier de type "*Layout Resource File*" dans le dossier "*res/layout*". Appeler ce fichier "*activity_main.xml*" et ajouter l'option "*Orientation = Landscape*". Ensuite, copier et adapter le layout à partir du du layout portrait.

## 3. Gestion des événements et mise à jour de l’interface utilisateur

### 3.1. Vérification du format de l’e-mail

Dans le fichier `MainActivity.kt`, ajouter le code suivant à la vérification des champs :

```kotlin
if (!emailInput!!.contains("@")) {
	Toast.makeText(applicationContext, "Invalid email", Toast.LENGTH_SHORT).show()
}
```

### 3.2. Vérification du couple e-mail / mot de passe

Toujours dans le fichier `MainActivity.kt`, ajouter le code suivant à la suite :

```kotlin
if (!credentials.contains(Pair(emailInput, passwordInput))) {
    AlertDialog.Builder(this).setMessage("Password incorrect").create().show()
} else {
    Toast.makeText(applicationContext, "Successful login", Toast.LENGTH_SHORT).show()
}
```



## 4. Passage à une autre activité

### 4.2. Passage de paramètres à la nouvelle activité

Dans MainActivity.kt :

```kotlin
// Start ContentActivity
val intent = Intent(this@MainActivity, ContentActivity::class.java)
intent.putExtra("email", emailInput)
startActivity(intent)
```

Puis dans ContentActivity.kt :

```kotlin
val email = intent.getStringExtra("email")
val textView = findViewById<TextView>(R.id.textView).apply {
    text = email
}
```



### 4.3. Permissions simples

Ajouter la ligne suivante dans AndroidManifest.xml :

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

Dans ContentActivity.kt : 

```kotlin
ImageDownloader(findViewById<ImageView>(R.id.avatarView), "https://thispersondoesnotexist.com/image").show()

```



## 5. Navigation entre les activités

### 5.2. Affichage d’une image

> *Dans quel(s) dossier(s) devons-nous ajouter cette image ?*

Dans le dossier `res/drawable`

> *Veuillez décrire brièvement la logique derrière la gestion des ressources de type « image matricielle » sur Android.*

Lors de l'importation d'image matricielle, plusieurs tailles sont générés pour que l'application puisse afficher l'image au format idéal par rapport à la taille de l'écran.

> *Quel intérêt voyez-vous donc à utiliser une image vectorielle ? Est-ce possible dans tous les cas ?*

Les images vectorielles s'adapte automatiquement à la taille de l'écran. Il n'est donc pas nécessaire d'avoir plusieurs copie de l'image en taille différentes.

Néanmoins, ces images sont uniquement adapté au 