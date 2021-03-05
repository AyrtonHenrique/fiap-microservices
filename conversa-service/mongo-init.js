
db = db.getSiblingDB("conversation-service");

db.createUser(
        {
            user: "ayrton",
            pwd: "123456",
            roles: [
                {
                    role: "readWrite",
                    db: "conversation-service"
                }
            ]
        }
);

db.createCollection('conversations');