# ReceiverDemo 📡

Une application Android d'apprentissage pour comprendre le fonctionnement des **Broadcast Receivers** (Statiques, Dynamiques et Custom).

<img src="demo/demo.gif" width="300" height="600">

## 🚀 Fonctionnalités

Cette application démontre trois types d'implémentations de Receivers :

1.  **Receiver Dynamique (Mode Avion)** :
    - Enregistré par programmation dans `MainActivity`.
    - Écoute l'action `ACTION_AIRPLANE_MODE_CHANGED`.
    - Peut être activé/désactivé via un bouton pour économiser les ressources.

2.  **Receiver Statique (Démarrage)** :
    - Déclaré dans le `AndroidManifest.xml`.
    - Écoute l'action `BOOT_COMPLETED`.
    - Fonctionne même si l'application n'est pas lancée.

3.  **Custom Broadcast** :
    - Envoi d'un Intent personnalisé (`com.example.receiverdemo.CUSTOM_EVENT`) via un bouton.
    - Réception par un receiver dédié pour illustrer la communication intra-app.

## 🛠️ Configuration technique

- **Langage** : Java
- **Permissions** : `RECEIVE_BOOT_COMPLETED` pour le receiver de démarrage.
- **Compatibilité** : Configuré avec `android:exported="false"` pour respecter les normes de sécurité d'Android 12+.

## 🧪 Comment tester ?

1.  **Mode Avion** :
    - Cliquez sur le bouton **"Activer Receiver Avion"**.
    - Ouvrez les paramètres rapides d'Android et basculez le mode avion.
    - Un Toast apparaîtra indiquant le nouvel état.

2.  **Custom Broadcast** :
    - Cliquez sur **"Envoyer Custom Broadcast"**.
    - Un Toast confirmera immédiatement la réception du message personnalisé.

3.  **Boot Receiver** :
    - Redémarrez l'appareil ou utilisez la commande ADB suivante :
      ```bash
      adb shell am broadcast -a android.intent.action.BOOT_COMPLETED
      ```

## 📝 Concepts clés abordés

- Utilisation de `IntentFilter`.
- Cycle de vie : `registerReceiver()` / `unregisterReceiver()`.
- Sécurité et permissions dans le Manifest.
- Gestion des Toasts pour le feedback utilisateur.
