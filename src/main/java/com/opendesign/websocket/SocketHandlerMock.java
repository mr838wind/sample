/*
 * Copyright (c) 2016 OpenDesign All rights reserved.
 *
 * This software is the confidential and proprietary information of OpenDesign.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with OpenDesign.
 */
package com.opendesign.websocket;

import java.io.IOException;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.opendesign.controller.CommonController;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 테스트에 사용되는 SocketHandler의 Mock Object
 * </pre>
 * 
 * @author hanchanghao
 * @since 2016. 11. 15.
 */
@Slf4j
public class SocketHandlerMock extends SocketHandler {

	/**
	 * 연결 끊힘
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("afterConnectionClosed");
	}

	/**
	 * 연결 확립
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("afterConnectionEstablished");
	}

	/**
	 * msg 처리
	 */
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("handleTextMessage");
	}

	/** IE 11에서 pongMessage를 보내옴, chrome에서는 안보내는것 같음 */
	@Override
	public void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		log.info("handlePongMessage");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.info("handleTransportError");
	}

	@Override
	public boolean supportsPartialMessages() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	/**
	 * client로 message 보냄
	 * 
	 * @param to
	 * @param params
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public void sendMessage(SessionMatch to, Map<String, Object> params) throws IOException {
		log.info("sendMessage");
	}

	/**
	 * 프로젝트 변경됨 메시지 보냄
	 * 
	 * @param projectSeq
	 * @throws JsonProcessingException
	 */
	public void notifyProjectChanged(String projectSeq) {
		log.info("notifyProjectChanged");
	}

	/**
	 * 알림 변경됨
	 * 
	 * @param alarmVO
	 */
	public void notifyAlarmChanged(String userSeq) {
		log.info("notifyAlarmChanged");
	}

	/**
	 * 메시지 변경됨
	 * 
	 * @param recieveSeq
	 */
	public void notifyMsgChanged(String userSeq) {
		log.info("notifyMsgChanged");
	}

}
