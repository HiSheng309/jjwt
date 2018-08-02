/*
 * Copyright (C) 2016 jsonwebtoken.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AuthenticatedEncryptionRequest;

import java.security.Key;
import java.security.SecureRandom;

/**
 * @since 0.11.0
 */
public class DefaultAuthenticatedEncryptionRequest<T extends Key> extends DefaultEncryptionRequest<T>
    implements AuthenticatedEncryptionRequest<T> {

    private final byte[] aad;

    public DefaultAuthenticatedEncryptionRequest(SecureRandom secureRandom, T key, byte[] iv, byte[] plaintext, byte[] aad) {
        super(secureRandom, key, iv, plaintext);
        Assert.notEmpty(aad, "Additional Authenticated Data cannot be null or empty.");
        this.aad = aad;
    }

    @Override
    public byte[] getAssociatedData() {
        return this.aad;
    }
}
