package io.github.uitests.common;

import io.github.uitests.config.DatabaseConfig;

public enum Environment {
    LOCAL {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getLocalConnectionString();
        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getLocalDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getLocalDbPassword();
        }
    },
    DEV {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getDevConnectionString();
        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getDeveloperEnvDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getDeveloperEnvDbPassword();
        }
    },
    TEST {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getTstConnectionString();
        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getDeveloperEnvDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getDeveloperEnvDbPassword();
        }
    },
    SQA {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getSqaConnectionString();
        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbPassword();
        }
    },
    UAT {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getUatConnectionString();
        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbPassword();
        }
    },
    PDT {
        @Override
        public String getDbUrlConnection(DatabaseConfig databaseConfig) {
            return databaseConfig.getPdtConnectionString();

        }

        @Override
        public String getDbUsername(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbUsername();
        }

        @Override
        public String getDbPassword(DatabaseConfig databaseConfig) {
            return databaseConfig.getCustomerEnvDbPassword();
        }
    };

    public abstract String getDbUrlConnection(DatabaseConfig databaseConfig);

    public abstract String getDbUsername(DatabaseConfig databaseConfig);

    public abstract String getDbPassword(DatabaseConfig databaseConfig);

}
