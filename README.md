# POE-part-2
Record and send messages
Welcome Message

Displays "Welcome to QuickChat" at program start using JOptionPane.

Main Menu (JOptionPane Options)

Option 1: Send Messages

Option 2: Show Recent Messages

Option 3: Quit Application

Send Messages Flow

Prompts user for number of messages to send.

For each message:

Prompts for:

Recipient number (must start with +27)

Message text (max 250 characters)

Generates:

10-digit random message ID

Message hash in format (XX:N) FIRSTWORD LASTWORD

Displays full message summary.

Asks user to choose:

Send – confirms sending

Store – saves message to an in-memory list

Delete – discards the message

Show Recent Messages

Displays all stored messages if available.

If none stored, shows "Coming soon..."

Quit

Exits the application.

Supporting Functions

generateMessageID() – creates random 10-digit string.

generateMessageHash() – builds message hash from ID, index, first and last words.
