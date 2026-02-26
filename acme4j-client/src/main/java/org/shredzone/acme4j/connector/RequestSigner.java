/*
 * acme4j - Java ACME client
 *
 * Copyright (C) 2026 Richard "Shred" Körber
 *   http://acme4j.shredzone.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.shredzone.acme4j.connector;

import java.net.URL;
import java.security.KeyPair;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.shredzone.acme4j.toolbox.JSONBuilder;

/**
 * Function for assembling and signing an ACME JOSE request.
 *
 * @since 5.0.0
 */
@FunctionalInterface
public interface RequestSigner {

    /**
     * Creates an ACME JOSE request.
     * <p>
     * Implementors can use
     * {@link org.shredzone.acme4j.toolbox.JoseUtils#createJoseRequest(URL, KeyPair,
     * JSONBuilder, String, String)} without giving the signing {@link KeyPair} out of
     * their control.
     *
     * @param url
     *         {@link URL} of the ACME call
     * @param payload
     *         ACME JSON payload. If {@code null}, a POST-as-GET request is generated
     *         instead.
     * @param nonce
     *         Nonce to be used. {@code null} if no nonce is to be used in the JOSE
     *         header.
     * @return JSON structure of the JOSE request, ready to be sent.
     * @see org.shredzone.acme4j.toolbox.JoseUtils#createJoseRequest(URL, KeyPair,
     * JSONBuilder, String, String)
     */
    JSONBuilder createRequest(URL url, @Nullable JSONBuilder payload, @Nullable String nonce);

}
