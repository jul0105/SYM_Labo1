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

